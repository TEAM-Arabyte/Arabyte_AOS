package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.NoticeBoardDetailCommentDto
import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetailComment

fun GetNoticeBoardDetailResponseDto.toDomainModel(): NoticeBoardDetail {
    return NoticeBoardDetail(
        articleId = this.articleId,
        nickname = this.nickname,
        createdAt = this.createdAt,
        title = this.title,
        text = this.text,
        likeCount = this.likeCount,
        commentCount = this.commentCount,
        comments = this.comments.map { it.toDomainModel() },
        imageUrls = this.imageUrls,
        isLiked = this.isLiked,
    )
}

fun NoticeBoardDetailCommentDto.toDomainModel(): NoticeBoardDetailComment {
    return NoticeBoardDetailComment(
        commentId = this.commentId,
        userId = this.userId,
        text = this.text,
        nickname = this.nickname,
        createdAt = this.createdAt,
        isAnonymous = this.isAnonymous,
        parentId = this.parentId,
    )
}
