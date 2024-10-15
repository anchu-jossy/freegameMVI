package com.example.myapplication.presentation.freegame.state

import com.example.myapplication.domain.model.FreeGames

data class GamesState(var gamesList : List<FreeGames> = emptyList(), var error : String?=null, var loading : Boolean=false)
