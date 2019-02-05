package com.chaturaloka.dota2.service.model

data class Hero(
    val id: Number?,
    val name: String?,
    val localized_name: String?,
    val primary_attr: String?,
    val attack_type: String?,
    val roles: List<String>?,
    val legs: Number?
)