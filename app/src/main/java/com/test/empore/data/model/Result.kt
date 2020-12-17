package com.test.empore.data.model

import com.google.gson.annotations.SerializedName

data class Result<T>(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<T> = listOf()
)
