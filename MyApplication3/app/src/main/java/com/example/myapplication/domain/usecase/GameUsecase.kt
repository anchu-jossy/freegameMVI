package com.example.myapplication.domain.usecase

import com.example.myapplication.core.common.Resource
import com.example.myapplication.domain.GamesRepository
import com.example.myapplication.domain.model.FreeGames
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameUsecase  @Inject constructor(val repo : GamesRepository) {

  suspend  fun invoke(): Flow<Resource<List<FreeGames>>> {
       return  repo.getGames()
    }
}