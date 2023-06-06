package com.harshad.showpostapp

import android.app.Application
import com.harshad.showpostapp.data.local.PostDatabase
import com.harshad.showpostapp.repository.PostRepository

class PostApplication : Application() {
    private val postDao by lazy {
        val roomDb = PostDatabase.getPostDatabaseInstance(this)
        roomDb.getPostDao()
    }
    val postRepository by lazy {
        PostRepository(postDao)
    }
}