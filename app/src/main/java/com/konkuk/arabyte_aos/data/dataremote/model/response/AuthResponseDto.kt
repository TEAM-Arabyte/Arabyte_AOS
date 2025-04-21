package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseDto(
    val userId: Int,
    val accessToken: String,
    val refreshToken: String,
    val isRegistered: Boolean,
)
