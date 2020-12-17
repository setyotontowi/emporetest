package com.test.empore.data.model

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id") var id:Int = 0,
    @SerializedName("name") var name: String = ""
)
