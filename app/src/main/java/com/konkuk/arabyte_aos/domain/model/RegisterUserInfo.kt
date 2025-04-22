package com.konkuk.arabyte_aos.domain.model

data class RegisterUserInfo(
    val nickname: String,
    val ageRange: String,
    val gender: String,
    val locationId: Int
)