package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.GetReviewDetailResponseDto
import com.konkuk.arabyte_aos.domain.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.domain.model.Overtime
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.model.ReviewHelpfulType
import com.konkuk.arabyte_aos.domain.model.ReviewRating
import com.konkuk.arabyte_aos.domain.model.Salary
import com.konkuk.arabyte_aos.domain.model.SalaryDate
import com.konkuk.arabyte_aos.domain.model.WorkAtmosphere
import com.konkuk.arabyte_aos.domain.model.WorkDifficulty
import com.konkuk.arabyte_aos.domain.model.WorkIntensity

fun GetReviewDetailResponseDto.toDomainModel(): ReviewDetail {
    return ReviewDetail(
        reviewId = this.reviewId,
        userId = this.userId,
        companyName = this.companyName,
        isCertified = this.isCertified,
        star = this.star,
        region = this.location,
        category = ArabyteJobCategory.valueOf(this.category),
        reviewRating =
            ReviewRating(
                workIntensity = WorkIntensity.valueOf(this.workIntensity),
                workAtmosphere = WorkAtmosphere.valueOf(this.workAtmosphere),
                salary = Salary.valueOf(this.salary),
                salaryDate = SalaryDate.valueOf(this.salaryDate),
                overtime = Overtime.valueOf(this.overtime),
                workDifficulty = WorkDifficulty.valueOf(this.difficulty),
            ),
        reviewContent = this.text,
        badCount = this.badCount,
        normalCount = this.normalCount,
        goodCount = this.goodCount,
        helpful = this.helpful?.let { ReviewHelpfulType.valueOf(it) },
    )
}
