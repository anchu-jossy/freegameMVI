package com.example.instagram.data.remote

data class PostItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int,
    val isOptionsRevealed: Boolean
)