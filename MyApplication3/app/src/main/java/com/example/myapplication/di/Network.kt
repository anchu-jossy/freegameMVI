package com.example.myapplication.di

import com.example.myapplication.data.remote.mapper.api.ApiService
import com.example.myapplication.data.remote.mapper.repo.GamesRepoImpl
import com.example.myapplication.domain.GamesRepository
import com.example.myapplication.domain.usecase.GameUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

@Provides
@Singleton
fun provideApiService(): ApiService {
    return Retrofit.Builder()
        .baseUrl("https://www.freetogame.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ApiService::class.java)

}

    @Provides
    @Singleton
    fun provideRepo(apiService: ApiService): GamesRepository{
        return GamesRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideUsecase(repo : GamesRepository):GameUsecase
    {
        return GameUsecase(repo)
    }





}