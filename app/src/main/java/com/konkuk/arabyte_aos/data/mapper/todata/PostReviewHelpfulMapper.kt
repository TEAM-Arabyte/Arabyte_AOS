package com.konkuk.arabyte_aos.data.mapper.todata

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewHelpfulRequestDto
import com.konkuk.arabyte_aos.domain.model.ReviewHelpfulType

fun ReviewHelpfulType.toRequestDto(): PostReviewHelpfulRequestDto {
    return PostReviewHelpfulRequestDto(
        helpful = this.name,
    )
}
