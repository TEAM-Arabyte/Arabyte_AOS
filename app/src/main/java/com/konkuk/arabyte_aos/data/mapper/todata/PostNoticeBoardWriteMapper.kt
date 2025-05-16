package com.konkuk.arabyte_aos.data.mapper.todata

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostNoticeBoardWriteRequestDto
import com.konkuk.arabyte_aos.domain.model.PostNoticeBoardWrite

fun PostNoticeBoardWrite.toRequestDto(): PostNoticeBoardWriteRequestDto {
    return PostNoticeBoardWriteRequestDto(
        title = this.title,
        text = this.text,
        likeCount = this.likeCount,
        isAnonymous = this.isAnonymous,
        articleKind = this.articleKind,
        articleImages = this.articleImages,
        anonymous = this.anonymous,
    )
}
