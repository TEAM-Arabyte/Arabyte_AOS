package com.konkuk.arabyte_aos.domain.model

data class NoticeBoardList(
    val totalElements: Long,
    val totalPages: Long,
    val first: Boolean,
    val last: Boolean,
    val size: Long,
    val content: List<NoticeBoardContent>,
    val number: Long,
    val sort: Sort,
    val numberOfElements: Long,
    val pageable: Pageable,
    val empty: Boolean,
)

data class NoticeBoardContent(
    val articleId: Long,
    val title: String,
    val text: String,
    val likeCount: Long,
    val commentCount: Long,
    val createdAt: String,
    val thumbnailImage: String,
    val articleKind: String,
    val isLiked: Boolean,
)

data class Pageable(
    val offset: Long,
    val sort: Sort,
    val paged: Boolean,
    val pageNumber: Long,
    val pageSize: Long,
    val unpaged: Boolean,
)

data class Sort(
    val empty: Boolean,
    val sorted: Boolean,
    val unsorted: Boolean,
)
