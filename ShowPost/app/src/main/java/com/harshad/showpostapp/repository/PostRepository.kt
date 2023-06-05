package com.harshad.showpostapp.repository


import com.harshad.showpostapp.data.remote.ApiService
import com.harshad.showpostapp.data.remote.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostRepository {

    val apiService = RetrofitInstance.getInstance().create(ApiService::class.java)

    fun fetchPostAndSaveIntoLocalDb() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiResponse = apiService.getPostList()
            for (i in apiResponse.indices){
             //add room db
            }
        }
    }
}