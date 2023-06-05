package com.harshad.showpostapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.harshad.showpostapp.repository.PostRepository

class PostViewFactory(private val postRepository: PostRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }
}