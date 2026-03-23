package com.example.treasurehunt.data

data class Clue(
    val clue: String,
    val hint: String,
    val latitude: Double,
    val longitude: Double,
    val info: String
)