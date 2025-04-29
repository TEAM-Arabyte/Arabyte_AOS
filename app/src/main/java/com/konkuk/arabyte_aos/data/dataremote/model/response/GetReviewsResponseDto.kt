package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetReviewsResponseDto(
    val totalElements: Int,
    val totalPages: Int,
    val first: Boolean,
    val last: Boolean,
    val size: Int,
    val content: List<ReviewContentDto>,
    val number: Int,
    val sort: SortDto,
    val numberOfElements: Int,
    val pageable: PageableDto,
    val empty: Boolean,
)

@Serializable
data class ReviewContentDto(
    val reviewId: Int,
    val isCertified: Boolean,
    val star: Float,
    val text: String,
    val location: ReviewLocationDto,
    val category: String,
)

@Serializable
data class ReviewLocationDto(
    val locationCode: String,
    val sido: String,
    val sidoCode: String,
    val gu: String,
    val guCode: String,
    val dong: String,
    val dongCode: String,
    val depth: Int,
    val id: Int,
    val createdAt: String,
    val updatedAt: String,
)

@Serializable
data class SortDto(
    val empty: Boolean,
    val sorted: Boolean,
    val unsorted: Boolean,
)

@Serializable
data class PageableDto(
    val offset: Int,
    val sort: SortDto,
    val paged: Boolean,
    val pageNumber: Int,
    val pageSize: Int,
    val unpaged: Boolean,
)
