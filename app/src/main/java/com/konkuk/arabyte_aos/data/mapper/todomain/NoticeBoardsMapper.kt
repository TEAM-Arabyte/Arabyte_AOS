package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardListResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.NoticeBoardContentDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.NoticeBoardListPageableDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.NoticeBoardListSortDto
import com.konkuk.arabyte_aos.domain.model.NoticeBoardContent
import com.konkuk.arabyte_aos.domain.model.NoticeBoardList
import com.konkuk.arabyte_aos.domain.model.Pageable
import com.konkuk.arabyte_aos.domain.model.Sort

fun GetNoticeBoardListResponseDto.toDomainModel(): NoticeBoardList {
    return NoticeBoardList(
        totalElements = this.totalElements,
        totalPages = this.totalPages,
        first = this.first,
        last = this.last,
        size = this.size,
        content = this.content.map { it.toDomainModel() },
        number = this.number,
        sort = this.sort.toDomainModel(),
        numberOfElements = this.numberOfElements,
        pageable = this.pageable.toDomainModel(),
        empty = this.empty,
    )
}

fun NoticeBoardContentDto.toDomainModel(): NoticeBoardContent {
    return NoticeBoardContent(
        articleId = this.articleId,
        title = this.title,
        text = this.text,
        likeCount = this.likeCount,
        commentCount = this.commentCount,
        createdAt = this.createdAt,
        thumbnailImage = this.thumbnailImage,
        articleKind = this.articleKind,
        isLiked = this.isLiked,
    )
}

fun NoticeBoardListSortDto.toDomainModel(): Sort {
    return Sort(
        empty = this.empty,
        sorted = this.sorted,
        unsorted = this.unsorted,
    )
}

fun NoticeBoardListPageableDto.toDomainModel(): Pageable {
    return Pageable(
        offset = this.offset,
        sort = this.sort.toDomainModel(),
        paged = this.paged,
        pageNumber = this.pageNumber,
        pageSize = this.pageSize,
        unpaged = this.unpaged,
    )
}
