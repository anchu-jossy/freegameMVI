package com.example.cryptocurrency.data.repository

import com.example.cryptocurrency.data.remote.CoinPaprikaApi
import com.example.cryptocurrency.data.remote.dto.CoinDetailDto
import com.example.cryptocurrency.data.remote.dto.CoinDto
import com.example.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(val api: CoinPaprikaApi): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        TODO("Not yet implemented")
    }
}