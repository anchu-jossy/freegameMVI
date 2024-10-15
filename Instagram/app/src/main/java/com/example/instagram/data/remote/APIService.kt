package com.example.instagram.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("/posts")
    suspend fun getPost():Response<Post>
}