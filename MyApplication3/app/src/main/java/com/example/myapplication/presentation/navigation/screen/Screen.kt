package com.example.myapplication.presentation.navigation.screen
sealed class Screen(val route: String) {
    object GameScreen : Screen("game_screen")
}
