package com.example.myapplication.domain.model

data class FreeGames(
    val gameUrl:String,
    val id: Int,
    val short_description: String,
    val thumbnail: String,
    val title: String
)