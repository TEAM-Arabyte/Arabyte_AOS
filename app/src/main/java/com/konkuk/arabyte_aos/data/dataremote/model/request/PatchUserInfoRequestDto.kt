package com.konkuk.arabyte_aos.data.dataremote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PatchUserInfoRequestDto(
    val nickname: String,
    val ageRange: String,
    val gender: String,
    val locationId: Int
)