package com.konkuk.arabyte_aos.presentation.model

data class NoticeBoardDetailComment(
    val commentId: Long,
    val parentId: Long?,
    val profileImage: String,
    val nickname: String,
    val content: String,
    val isAnonymous: Boolean,
)
