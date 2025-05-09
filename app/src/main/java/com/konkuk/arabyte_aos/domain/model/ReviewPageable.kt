package com.konkuk.arabyte_aos.domain.model

data class ReviewPageable(
    val offset: Int,
    val sort: ReviewSort,
    val paged: Boolean,
    val pageNumber: Int,
    val pageSize: Int,
    val unpaged: Boolean,
)
