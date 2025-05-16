package com.konkuk.arabyte_aos.domain.model

data class PostNoticeBoardWrite(
    val title: String,
    val text: String,
    val likeCount: Long,
    val isAnonymous: Boolean,
    val articleKind: String,
    val articleImages: List<String>,
    val anonymous: Boolean,
)
