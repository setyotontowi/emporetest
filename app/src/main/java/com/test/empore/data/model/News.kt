package com.test.empore.data.model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("source")
    val source: Source = Source(),
    @SerializedName("author")
    val author:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("url")
    var url: String,
    @SerializedName("urlToImage")
    var imageUrl: String,
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("content")
    var content: String

)
