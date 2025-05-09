package com.konkuk.arabyte_aos.data.dataremote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostReportRequestDto(
    val reportType: String,
    val targetId: Long,
    val reason: String,
)
