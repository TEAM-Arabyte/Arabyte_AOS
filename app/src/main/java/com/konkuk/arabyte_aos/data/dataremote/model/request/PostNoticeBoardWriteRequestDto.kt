package com.konkuk.arabyte_aos.data.dataremote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostNoticeBoardWriteRequestDto(
    val title: String,
    val text: String,
    val likeCount: Long,
    val isAnonymous: Boolean,
    val articleKind: String,
    val articleImages: List<String>,
    val anonymous: Boolean,
)
