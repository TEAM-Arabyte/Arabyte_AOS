package com.konkuk.arabyte_aos.domain.model

data class PostComment(
    val articleId: Long,
    val text: String,
    val parentId: Long,
    val isAnonymous: Boolean,
)
