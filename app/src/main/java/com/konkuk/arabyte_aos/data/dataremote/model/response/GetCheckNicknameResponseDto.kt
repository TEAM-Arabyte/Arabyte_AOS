package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetCheckNicknameResponseDto(
    val isDuplicate: Boolean
)
