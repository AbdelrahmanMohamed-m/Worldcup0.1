package com.example.worldcup.data.domain

import java.io.Serializable


data class Match(
    val year: Int,
    val stadium: String,
    val city: String,
    val RightTeamName: String,
    val LeftTeamName: String,
    val RightTeamGoals: Int,
    val LeftTeamGoals: Int,
):Serializable