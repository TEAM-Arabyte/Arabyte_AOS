package com.konkuk.arabyte_aos.domain.model

data class Auth(
    val userId: Int,
    val accessToken: String,
    val refreshToken: String,
    val isRegistered: Boolean,
)
