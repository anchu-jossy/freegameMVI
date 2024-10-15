package com.example.myapplication.presentation.freegame.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.common.Resource
import com.example.myapplication.domain.usecase.GameUsecase
import com.example.myapplication.presentation.freegame.state.GamesState
import com.example.myapplication.presentation.freegame.state.UiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewmodel @Inject constructor(val useCase: GameUsecase) : ViewModel() {
    private var _state = MutableStateFlow(GamesState())
    val freeGameState: StateFlow<GamesState>
        get() = _state

    val _uiEffect = MutableSharedFlow<UiEffect>()
       val uiEffect=_uiEffect.asSharedFlow()

    init {
        getGames()
    }

    fun getGames() {
        viewModelScope.launch {
            useCase.invoke()
                .collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            _state.value =
                                (GamesState().copy(error = result.message, loading = false))


                        }

                        is Resource.Loading -> {
                            _state.value =
                                (GamesState().copy(loading = true))

                        }

                        is Resource.Success -> {
                            _state.value =
                                GamesState().copy(
                                    gamesList = result.data ?: emptyList(),
                                    loading = false
                                )


                            _uiEffect.emit(UiEffect.ShowSnackBar("Data is successfullt fetched"))
                        }


                    }
                }
        }
    }

}




