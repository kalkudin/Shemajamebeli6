package com.example.shemajamebeli5.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @Json(name = "new_courses") val newCourse: List<NewCourse>,
    @Json(name = "active_courses") val activeCourse: List<ActiveCourse>
)
