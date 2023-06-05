package com.harshad.showpostapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePost(post: PostEntity)

    @Query("SELECT * FROM POST_TABLE")
    fun getAllPost(): List<PostEntity>
}