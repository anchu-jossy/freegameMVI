package com.example.myapplication.data.remote.mapper.api

import com.example.myapplication.data.remote.mapper.dto.FreeGamesDtoItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("games")
  suspend  fun getGames():Response<List<FreeGamesDtoItem>>
}