package com.example.myapplication.presentation.freegame.state

sealed class UiEffect {
    class ShowSnackBar(val msg: String) : UiEffect()
}