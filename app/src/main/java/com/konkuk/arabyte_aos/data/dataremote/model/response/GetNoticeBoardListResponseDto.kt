package com.konkuk.arabyte_aos.data.dataremote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class GetNoticeBoardListResponseDto(
    val totalElements: Long,
    val totalPages: Long,
    val first: Boolean,
    val last: Boolean,
    val size: Long,
    val content: List<NoticeBoardContentDto>,
    val number: Long,
    val sort: NoticeBoardListSortDto,
    val numberOfElements: Long,
    val pageable: NoticeBoardListPageableDto,
    val empty: Boolean,
)

@Serializable
data class NoticeBoardContentDto(
    val articleId: Long,
    val title: String,
    val text: String,
    val likeCount: Long,
    val commentCount: Long,
    val createdAt: String,
    val thumbnailImage: String?,
    val articleKind: String,
    val isLiked: Boolean,
)

@Serializable
data class NoticeBoardListPageableDto(
    val offset: Long,
    val sort: NoticeBoardListSortDto,
    val paged: Boolean,
    val pageNumber: Long,
    val pageSize: Long,
    val unpaged: Boolean,
)

@Serializable
data class NoticeBoardListSortDto(
    val empty: Boolean,
    val sorted: Boolean,
    val unsorted: Boolean,
)
