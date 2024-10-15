package com.example.myapplication.presentation.freegame.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.myapplication.presentation.freegame.state.GamesState

@Composable
fun  GameScreen( state: GamesState, modifier: Modifier) {

    if(state.gamesList.isNotEmpty()){
        LazyColumn {
            items(state.gamesList){
               GamesItem(modifier = modifier, games =it )
            }

        }
    }
    else if(state.loading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator()

        }
    }
}