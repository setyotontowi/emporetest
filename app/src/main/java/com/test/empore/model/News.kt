package com.test.empore.model

import java.util.*

data class News(
    var id:Int,
    var title:String,
    var date:Calendar,
    var source: String,
    var country: String,
    var imageUrl: String,
    var url: String
)
