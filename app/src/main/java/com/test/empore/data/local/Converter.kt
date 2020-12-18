package com.test.empore.data.local

import androidx.room.TypeConverter
import com.test.empore.data.model.Source
import java.text.SimpleDateFormat
import java.util.*

class Converter {
    @TypeConverter
    fun fromSourceToString(source: Source?): String {
        return source!!.name
    }

    @TypeConverter
    fun fromStringToSource(name: String): Source {
        val source = Source()
        source.name = name
        return source
    }

    private fun fromStringToDate(dateString: String): Date? {
        return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).parse(dateString)
    }

    private fun fromDateToString(date: Date): String {
        return SimpleDateFormat("dd MMMM yyyy - HH:mm", Locale("id", "id")).format(date)
    }

    fun convertDateFormat(stringDate: String): String {
        val date = fromStringToDate(stringDate)!!
        return fromDateToString(date)
    }
}