package com.example.shemajamebeli5.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewCourse(
    val id: String,
    @Json(name = "icon_type") val iconType: String,
    val duration: String,
    val title: String,
    val question: String,
    @Json(name = "main_color") val mainColor: String
)