package com.example.instagram.di

import com.example.instagram.data.remote.APIService
import com.example.instagram.data.remote.PostRepoImpl
import com.example.instagram.domain.usecase.PostUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {


    @Provides
    @Singleton
    fun provideRetrofit():APIService{
       return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService::class.java)

    }

    @Provides
    @Singleton
    fun provideRepository(apiService: APIService):PostRepoImpl{
        return PostRepoImpl(apiService)
    }


    @Provides
    @Singleton
    fun provideUsecase(repoImpl: PostRepoImpl):PostUsecase{
        return PostUsecase(repoImpl)
    }


}

