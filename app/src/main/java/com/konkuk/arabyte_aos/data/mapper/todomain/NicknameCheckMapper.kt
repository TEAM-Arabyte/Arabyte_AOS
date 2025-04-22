package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.GetCheckNicknameResponseDto
import com.konkuk.arabyte_aos.domain.model.NicknameCheck

fun GetCheckNicknameResponseDto?.toDomainModel(): NicknameCheck {
    return NicknameCheck(
        isDuplicate = this?.isDuplicate ?: true
    )
}
