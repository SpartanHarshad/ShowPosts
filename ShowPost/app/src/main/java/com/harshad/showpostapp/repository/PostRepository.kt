package com.harshad.showpostapp.repository


import com.harshad.showpostapp.data.local.PostDao
import com.harshad.showpostapp.data.local.PostEntity
import com.harshad.showpostapp.data.remote.ApiService
import com.harshad.showpostapp.data.remote.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostRepository(private val postDao: PostDao) {

    private val apiService: ApiService =
        RetrofitInstance.getInstance().create(ApiService::class.java)

    fun fetchPostAndSaveIntoLocalDb() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiResponse = apiService.getPostList()
            for (i in apiResponse.indices) {
                val postEntity = PostEntity(
                    apiResponse[i].userId ?: 0,
                    apiResponse[i].id ?: 0,
                    apiResponse[i].title ?: "",
                    apiResponse[i].body ?: ""
                )
                postDao.savePost(postEntity)
            }
        }
    }

    fun getALlPosts(): List<PostEntity> {
        return postDao.getAllPost()
    }
}