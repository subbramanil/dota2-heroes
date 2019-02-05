package com.chaturaloka.dota2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.chaturaloka.dota2.service.model.Hero
import org.junit.Rule

class OpenDotaServiceTest : BaseTest() {

    override fun isMockServerEnabled(): Boolean = true

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule() // Force tests to be executed synchronously

    private val EXPECTED_HERO = Hero(
        1,
        "npc_dota_hero_antimage",
        "Anti-Mage",
        "agi",
        "Melee", listOf("Carry", "Escape", "Nuker"),
        2
    )

}