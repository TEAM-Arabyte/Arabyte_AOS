package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PatchUserInfoResponseDto(
    val isRegistered: Boolean,
    val userId: Int
    )
