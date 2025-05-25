package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyInfoResponseDto(
    @SerialName("userName")
    val userName: String,

    @SerialName("location")
    val location: String,

    @SerialName("ageRange")
    val age: String,

    @SerialName("gender")
    val gender: String,

    @SerialName("experienceYears")
    val experienceYears: Int,

    @SerialName("experienceMonths")
    val experienceMonths: Int,

    @SerialName("jobInterests")
    val jobInterests: List<String>
)
