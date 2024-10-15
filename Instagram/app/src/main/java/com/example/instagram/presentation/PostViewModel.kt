package com.example.instagram.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagram.data.remote.Post
import com.example.instagram.data.remote.PostItem
import com.example.instagram.data.remote.PostRepoImpl
import com.example.instagram.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.truncate

@HiltViewModel
class PostViewModel @Inject constructor(private val usecase: PostRepoImpl) : ViewModel() {
    var _stateFlow = MutableStateFlow(PostState())
    val stateFlow = _stateFlow.asStateFlow()
init {
    getPosts()
}
    fun getPosts() {
        viewModelScope.launch {
            usecase.getPost().collect {
                when (it) {
                    is Resource.Sucess -> {
                        it.data?.let {post->
                            _stateFlow.value =
                                _stateFlow.value.copy(post,loading = false)
                        }

                    }

                    is Resource.Error -> {

                        _stateFlow.value =
                            _stateFlow.value.copy(error = it.message, loading = false)
                    }
                    is Resource.Loading -> {
                        _stateFlow.value =
                            _stateFlow.value.copy(loading = true)
                    }
                }


            }
        }
    }
}


data class PostState(
    val post: Post=Post(),
    val error: String? = null,
    val loading: Boolean? = null
)