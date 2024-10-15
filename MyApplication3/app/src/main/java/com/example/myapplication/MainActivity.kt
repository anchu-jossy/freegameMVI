package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.presentation.freegame.viewmodel.GamesViewmodel
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.freegame.components.GameScreen
import com.example.myapplication.presentation.freegame.state.UiEffect
import com.example.myapplication.presentation.navigation.screen.Screen
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("RememberReturnType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MyApplicationTheme {
                val freeGameViewModel = hiltViewModel<GamesViewmodel>()
                var snackbarHostState= remember {
                    SnackbarHostState()
                }
                val state by freeGameViewModel.freeGameState.collectAsStateWithLifecycle()
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    }, modifier = Modifier.fillMaxSize()) { innerPadding ->
                        NavHost(
                            modifier = Modifier.padding(innerPadding),
                            navController = navController,
                            startDestination = Screen.GameScreen.route,

                            ) {

                            composable(Screen.GameScreen.route) {
                                LaunchedEffect(true) {
                                    freeGameViewModel.uiEffect.collectLatest {
                                        when (it) {
                                            is UiEffect.ShowSnackBar ->
                                            {
                                                snackbarHostState.showSnackbar(it.msg,duration = SnackbarDuration.Long)
                                            }
                                        }
                                    }
                                }
                                GameScreen(state, modifier = Modifier)
                            }
                        }
                    }
                }



            }
        }
    }

}





