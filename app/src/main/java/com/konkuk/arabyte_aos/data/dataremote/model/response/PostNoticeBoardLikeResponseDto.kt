package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PostNoticeBoardLikeResponseDto(
    val liked: Boolean,
    val likeCount: Int,
)
