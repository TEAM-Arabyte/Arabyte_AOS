package com.konkuk.arabyte_aos.domain.model

data class ReviewList(
    val totalElements: Int,
    val totalPages: Int,
    val first: Boolean,
    val last: Boolean,
    val size: Int,
    val content: List<ReviewItem>,
    val number: Int,
    val sort: ReviewSort,
    val numberOfElements: Int,
    val pageable: ReviewPageable,
    val empty: Boolean,
)
