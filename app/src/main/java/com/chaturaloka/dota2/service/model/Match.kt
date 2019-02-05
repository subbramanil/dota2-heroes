package com.chaturaloka.dota2.service.model

data class Match(
    val match_id: Number?,
    val start_time: Number?,
    val duration: Number?,
    val radiant_win: Boolean?,
    val leagueid: Number?,
    val league_name: String?,
    val radiant: Boolean?,
    val player_slot: Number?,
    val account_id: Number?,
    val kills: Number?,
    val deaths: Number?,
    val assists: Number?
)
