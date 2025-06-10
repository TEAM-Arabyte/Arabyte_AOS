package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.PostNoticeBoardLikeResponseDto
import com.konkuk.arabyte_aos.domain.model.NoticeBoardLike

fun PostNoticeBoardLikeResponseDto.toDomain(): NoticeBoardLike =
    NoticeBoardLike(
        liked = this.liked,
        likeCount = this.likeCount,
    )
