package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.AuthResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.ContractVerificationResponseDto
import com.konkuk.arabyte_aos.domain.model.Auth

fun ContractVerificationResponseDto.toDomainModel(): Boolean {
    return this.verifyResult
}
