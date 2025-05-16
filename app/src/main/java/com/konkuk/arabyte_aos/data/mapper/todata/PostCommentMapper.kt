package com.konkuk.arabyte_aos.data.mapper.todata

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostCommentRequestDto
import com.konkuk.arabyte_aos.domain.model.PostComment

fun PostComment.toRequestDto(): PostCommentRequestDto {
    return PostCommentRequestDto(
        articleId = this.articleId,
        text = this.text,
        parentId = this.parentId,
        isAnonymous = this.isAnonymous,
    )
}
