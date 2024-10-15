package com.example.myapplication.data.remote.mapper.repo

import com.example.myapplication.core.common.Resource
import com.example.myapplication.data.remote.mapper.api.ApiService
import com.example.myapplication.data.remote.mapper.toDomainFreeGames
import com.example.myapplication.domain.GamesRepository
import com.example.myapplication.domain.model.FreeGames
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GamesRepoImpl @Inject constructor(private val apiService: ApiService) : GamesRepository {
    override suspend fun getGames(): Flow<Resource<List<FreeGames>>> {
        return flow {
            // Emit loading state with an empty list
            emit(Resource.Loading())


            val result = apiService.getGames()

            if (result.isSuccessful) {
                val response = result.body()?.map { it.toDomainFreeGames() }

                if (response.isNullOrEmpty()) {
                    // Emit error with an empty list and a message
                    emit(Resource.Error(message = "No data available"))
                } else {
                    // Emit success with the response data
                    emit(Resource.Success(response))
                }
            }
        }
            .catch {
                emit(Resource.Error(message = "Network error: ${it.message}"))

            }
    }
}
