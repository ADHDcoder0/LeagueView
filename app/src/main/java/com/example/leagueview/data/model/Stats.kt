package com.example.leagueview.data.model

data class Stats(
    val wins: Int,
    val losses: Int,
    val ties: Int,
    val gamesPlayed: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val points: Int,
    val rank: Int,
    val goalDifference: Int
)
