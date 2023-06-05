package com.harshad.showpostapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostEntity::class], version = 1, exportSchema = true)
abstract class PostDatabase : RoomDatabase() {

    abstract fun getPostDao(): PostDao

    companion object {
        private var INSTANCE: PostDatabase? = null

        fun getPostDatabaseInstance(context: Context): PostDatabase {
            return if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext, PostDatabase::class.java,
                    "PostDB"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                INSTANCE!!
            } else {
                INSTANCE!!
            }
        }
    }
}