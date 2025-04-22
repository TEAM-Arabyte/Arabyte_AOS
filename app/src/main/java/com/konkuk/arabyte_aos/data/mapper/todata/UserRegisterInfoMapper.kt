package com.konkuk.arabyte_aos.data.mapper.todata

import com.konkuk.arabyte_aos.data.dataremote.model.request.PatchUserInfoRequestDto
import com.konkuk.arabyte_aos.domain.model.RegisterUserInfo

fun RegisterUserInfo.toData(): PatchUserInfoRequestDto =
    PatchUserInfoRequestDto(
        nickname = this.nickname,
        ageRange = this.ageRange,
        gender = this.gender,
        locationId = this.locationId,
    )
