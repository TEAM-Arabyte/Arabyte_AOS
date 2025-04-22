package com.konkuk.arabyte_aos.data.mapper.todata

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostOnboardingRequestDto
import com.konkuk.arabyte_aos.domain.model.UserOnboardingInfo

fun UserOnboardingInfo.toData(): PostOnboardingRequestDto =
    PostOnboardingRequestDto(
        experienceYears = this.experienceYears,
        experienceMonths = this.experienceMonths,
        jobInterests = this.jobInterests.map { it.name }
    )
