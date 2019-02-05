package com.chaturaloka.dota2.service.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chaturaloka.dota2.service.model.Hero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HeroRepository {

    private val openDotaService: OpenDotaService

    private lateinit var heroRepository: HeroRepository

    init {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.opendota.com/api/")
            .build()
        openDotaService = retrofit.create(OpenDotaService::class.java)
    }

    fun getHeroesList(): LiveData<List<Hero>> {
        val data = MutableLiveData<List<Hero>>()

        openDotaService.getHeroesList().enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {

                if (response.isSuccessful) {
                    Log.d(
                        "HeroRepository",
                        "onResponse (line 36): Received Heroes List successfully}"
                    )
                    data.value = response.body()
                } else {
                    Log.d(
                        "HeroRepository",
                        "onResponse (line 39): API Call failed with http error code: ${response.code()}"
                    )
                }
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                // TODO better error handling in part #2 ...
                Log.d("HeroRepository", "onFailure (line 45): ${t.message}")
                data.value = null
            }
        })

        return data
    }

}