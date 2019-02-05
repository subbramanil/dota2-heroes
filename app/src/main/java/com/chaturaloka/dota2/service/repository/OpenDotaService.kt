package com.chaturaloka.dota2.service.repository

import com.chaturaloka.dota2.service.model.Hero
import com.chaturaloka.dota2.service.model.Match
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface OpenDotaService {

    @GET("heroes")
    fun getHeroesList(): Call<List<Hero>>

    @GET("heroes/{dota2_hero_id}/matches")
    fun getRecentMatchesForHero(@Path("dota2_hero_id") heroId: String): Call<List<Match>>
}