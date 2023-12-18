package com.example.shemajamebeli5.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ActiveCourse(
    val id: String,
    @Json(name = "booking_time") val bookingTime: String,
    val progress: String,
    val title: String,
    @Json(name = "main_color") val mainColor: String,
    @Json(name = "background_color_present") val backgroundColorPresent: String,
    @Json(name = "play_button_color_present") val playButtonColorPresent: String,
    val image: String
)