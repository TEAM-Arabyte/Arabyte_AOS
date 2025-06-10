package com.konkuk.arabyte_aos.data.dataremote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostNoticeBoardLikeRequestDto(
    val articleId: Long,
)
