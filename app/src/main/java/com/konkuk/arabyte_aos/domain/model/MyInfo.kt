package com.konkuk.arabyte_aos.domain.model

data class MyInfo(
    val userName: String,
    val location: String,
    val age:String,
    val gender: String,
    val experienceYears: Int,
    val experienceMonths: Int,
    val jobInterests: List<String>
)