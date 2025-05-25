package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetNoticeBoardDetailResponseDto(
    val articleId: Long,
    val nickname: String,
    val createdAt: String,
    val title: String,
    val text: String,
    val likeCount: Long,
    val commentCount: Long,
    val comments: List<NoticeBoardDetailCommentDto>,
    val imageUrls: List<String>,
    val isLiked: Boolean,
)

@Serializable
data class NoticeBoardDetailCommentDto(
    val commentId: Long,
    val userId: Long,
    val text: String,
    val nickname: String,
    val createdAt: String,
    val isAnonymous: Boolean,
    val parentId: Long?,
)
