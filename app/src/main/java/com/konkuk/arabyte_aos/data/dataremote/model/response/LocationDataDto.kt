package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class LocationDataDto(
    val locationCode: String,
    val sido: String? = null,
    val sidoCode: String,
    val gu: String? = null,
    val guCode: String,
    val dong: String? = null,
    val dongCode: String,
    val depth: Int,
    val id: Int,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
