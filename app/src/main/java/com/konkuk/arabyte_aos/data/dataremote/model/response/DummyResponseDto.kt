package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyResponseDto(
    @SerialName("dummy")
    val dummy: String
)