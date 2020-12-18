package com.test.empore.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news")
data class News(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("source")
    var source: Source = Source(),
    @SerializedName("author")
    var author:String?,
    @SerializedName("title")
    var title:String?,
    @SerializedName("description")
    var description:String?,
    @SerializedName("url")
    var url: String,
    @SerializedName("urlToImage")
    var imageUrl: String?,
    @SerializedName("publishedAt")
    var publishedAt: String?,
    @SerializedName("content")
    var content: String?,
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false
)
