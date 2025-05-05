package com.konkuk.arabyte_aos.domain.model

data class NoticeBoardDetail(
    val articleId: Long,
    val nickname: String,
    val createdAt: String,
    val title: String,
    val text: String,
    val likeCount: Long,
    val commentCount: Long,
    val comments: List<NoticeBoardDetailComment>,
    val imageUrls: List<String>,
    val isLiked: Boolean,
)

data class NoticeBoardDetailComment(
    val commentId: Long,
    val userId: Long,
    val text: String,
    val nickname: String,
    val createdAt: String,
    val isAnonymous: Boolean,
    val parentId: Long? = null,
)
