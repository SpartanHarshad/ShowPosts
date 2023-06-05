package com.harshad.showpostapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "POST_TABLE")
data class PostEntity(
    @ColumnInfo(name = "userId") var userId: Int,
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "body") var body: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pId")
    var pId: Int = 0
}