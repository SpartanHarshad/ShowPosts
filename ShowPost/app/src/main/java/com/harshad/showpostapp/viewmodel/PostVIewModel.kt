package com.harshad.showpostapp.viewmodel

import androidx.lifecycle.ViewModel
import com.harshad.showpostapp.data.local.PostEntity
import com.harshad.showpostapp.repository.PostRepository


class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    fun loadPost() {
        postRepository.fetchPostAndSaveIntoLocalDb()
    }

    fun getAllLocalPost(): List<PostEntity> {
        return postRepository.getALlPosts()
    }
}