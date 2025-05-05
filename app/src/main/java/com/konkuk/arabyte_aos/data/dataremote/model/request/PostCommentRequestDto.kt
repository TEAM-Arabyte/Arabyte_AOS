package com.konkuk.arabyte_aos.data.dataremote.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostCommentRequestDto(
    val articleId: Long,
    val text: String,
    val parentId: Long,
    val isAnonymous: Boolean,
)
