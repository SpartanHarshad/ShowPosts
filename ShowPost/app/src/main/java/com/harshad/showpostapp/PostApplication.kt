package com.harshad.showpostapp

import android.app.Application
import com.harshad.showpostapp.repository.PostRepository

class PostApplication : Application() {

    val postRepository by lazy {
        PostRepository()
    }
}