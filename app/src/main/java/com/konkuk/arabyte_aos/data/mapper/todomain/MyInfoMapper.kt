package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.MyInfoResponseDto
import com.konkuk.arabyte_aos.domain.model.MyInfo

fun MyInfoResponseDto.toDomainModel(): MyInfo {
    return MyInfo(
        userName = this.userName,
        location = this.location,
        age = this.age,
        gender = this.gender,
        experienceYears = this.experienceYears,
        experienceMonths = this.experienceMonths,
        jobInterests = this.jobInterests
    )
}
