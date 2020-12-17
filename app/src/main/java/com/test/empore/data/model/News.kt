package com.test.empore.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class News(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("source") @Ignore
    val source: Source = Source(),
    @ColumnInfo(name = "source")
    val provider: String?,
    @SerializedName("author")
    val author:String?,
    @SerializedName("title")
    val title:String?,
    @SerializedName("description")
    val description:String?,
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
