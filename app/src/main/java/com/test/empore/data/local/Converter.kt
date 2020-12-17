package com.test.empore.data.local

import androidx.room.TypeConverter
import com.test.empore.data.model.Source

class Converter {
    @TypeConverter
    fun fromSourceToString(source: Source?):String{
        return source!!.name
    }

    @TypeConverter
    fun fromStringToSource(name: String):Source{
        val source = Source()
        source.name = name
        return source
    }
}