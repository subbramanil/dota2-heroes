package com.chaturaloka.dota2

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import java.io.File


abstract class BaseTest {

    //    lateinit var testAppComponent: TestAppComponent
    lateinit var mockServer: MockWebServer
//    @Inject lateinit var viewModelFactory: ViewModelFactory

    @Before
    open fun setUp() {
        this.configureMockServer()
        this.configureDi()
    }

    @After
    open fun tearDown() {
        this.stopMockServer()
    }

    // CONFIGURATION
    open fun configureDi() {
        /*this.testAppComponent = DaggerTestAppComponent.builder()
            .netModule(NetModule(if (isMockServerEnabled()) mockServer.url("/").toString() else BASE_URL))
            .repositoryModule(RepositoryModule())
            .build()
        this.testAppComponent.inject(this)*/
    }

    // MOCK SERVER
    abstract fun isMockServerEnabled(): Boolean // Because we don't want it always enabled on all tests

    open fun configureMockServer() {
        if (isMockServerEnabled()) {
            mockServer = MockWebServer()
            mockServer.start()
        }
    }

    open fun stopMockServer() {
        if (isMockServerEnabled()) {
            mockServer.shutdown()
        }
    }

    open fun mockHttpResponse(fileName: String, responseCode: Int) = mockServer.enqueue(
        MockResponse()
            .setResponseCode(responseCode)
            .setBody(getJson(fileName))
    )

    private fun getJson(path: String): String {
        val uri = this.javaClass.classLoader.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}