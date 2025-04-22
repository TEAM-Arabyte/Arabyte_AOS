package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.AuthResponseDto
import com.konkuk.arabyte_aos.domain.model.Auth

fun AuthResponseDto.toDomainModel(): Auth {
    return Auth(
        userId = this.userId,
        accessToken = this.accessToken,
        refreshToken = this.refreshToken,
        isRegistered = this.isRegistered,
    )
}
