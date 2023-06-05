package com.harshad.showpostapp.viewmodel

import androidx.lifecycle.ViewModel
import com.harshad.showpostapp.repository.PostRepository


class PostViewModel(val postRepository: PostRepository) : ViewModel() {

    fun getPost() {
        postRepository.fetchPostAndSaveIntoLocalDb()
    }
}