package com.example.instagram.data.remote

import com.example.instagram.domain.PostRepoInterface
import com.example.instagram.domain.util.Resource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostRepoImpl @Inject constructor(val apiService: APIService) : PostRepoInterface {
    override suspend fun getPost(): Flow<Resource<Post>> = flow {
        emit(Resource.Loading(isLoading = true))
        try {
            val response = apiService.getPost()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Sucess(it))
                    emit(Resource.Loading(isLoading = false))

                }

            } else {
                emit(Resource.Loading(isLoading = false))

                emit(Resource.Error(error = "Error response ${response.code()}"))
            }


        } catch (e: HttpException) {
            emit(Resource.Loading(isLoading = false))
            emit(Resource.Error(error = "Unauthorized acesss"))
        } catch (e: IOException) {
            emit(Resource.Error(error = "Network is not available"))
            emit(Resource.Loading(isLoading = false))

        }

    }
}