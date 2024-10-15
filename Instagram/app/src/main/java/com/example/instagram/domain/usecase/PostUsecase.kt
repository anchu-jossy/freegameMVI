package com.example.instagram.domain.usecase

import com.example.instagram.domain.PostRepoInterface
import javax.inject.Inject

class PostUsecase @Inject constructor(val  postRepository: PostRepoInterface) {
suspend fun invoke()= postRepository.getPost()
}