package com.example.instagram.domain

import com.example.instagram.data.remote.Post
import com.example.instagram.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface PostRepoInterface {
    suspend fun getPost(): Flow<Resource<Post>>

}