package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewsResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.PageableDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.ReviewContentDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.ReviewLocationDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.SortDto
import com.konkuk.arabyte_aos.domain.model.ReviewItem
import com.konkuk.arabyte_aos.domain.model.ReviewList
import com.konkuk.arabyte_aos.domain.model.ReviewPageable
import com.konkuk.arabyte_aos.domain.model.ReviewSort

// GetReviewsResponseDto -> ReviewList
fun GetReviewsResponseDto.toDomainModel(): ReviewList {
    return ReviewList(
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

// ReviewContentDto -> ReviewContent
fun ReviewContentDto.toDomainModel(): ReviewItem {
    return ReviewItem(
        reviewItemId = this.reviewId,
        isCertified = this.isCertified,
        star = this.star,
        content = this.text,
        region = this.location.toDomainString(),
        category = this.category,
        companyName = "나중에 준대",
    )
}

// ReviewLocationDto -> ReviewLocation
fun ReviewLocationDto.toDomainString(): String {
    return this.sido + this.gu + this.dong
}

// SortDto -> ReviewSort
fun SortDto.toDomainModel(): ReviewSort {
    return ReviewSort(
        empty = this.empty,
        sorted = this.sorted,
        unsorted = this.unsorted,
    )
}

// PageableDto -> ReviewPageable
fun PageableDto.toDomainModel(): ReviewPageable {
    return ReviewPageable(
        offset = this.offset,
        sort = this.sort.toDomainModel(),
        paged = this.paged,
        pageNumber = this.pageNumber,
        pageSize = this.pageSize,
        unpaged = this.unpaged,
    )
}
