package com.konkuk.arabyte_aos.data.mapper.todata

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostReviewRequestDto
import com.konkuk.arabyte_aos.domain.model.PostReview

fun PostReview.toRequestDto(): PostReviewRequestDto {
    return PostReviewRequestDto(
        companyId = this.companyId,
        locationId = this.locationId,
        category = this.category.name,
        text = this.text,
        rating = this.star,
        workIntensity = this.reviewRating.workIntensity.name,
        workAtmosphere = this.reviewRating.workAtmosphere.name,
        salary = this.reviewRating.salary.name,
        salaryDate = this.reviewRating.salaryDate.name,
        overtime = this.reviewRating.overtime.name,
        difficulty = this.reviewRating.workDifficulty.name,
    )
}
