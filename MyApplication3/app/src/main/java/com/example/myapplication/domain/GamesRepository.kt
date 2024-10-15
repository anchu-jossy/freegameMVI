package com.example.myapplication.domain

import com.example.myapplication.core.common.Resource
import com.example.myapplication.domain.model.FreeGames
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
  suspend  fun getGames(): Flow<Resource<List<FreeGames>>>
}