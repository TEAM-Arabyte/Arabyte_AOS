package com.konkuk.arabyte_aos.data.mapper.todomain

import com.konkuk.arabyte_aos.data.dataremote.model.response.ContractVerificationResponseDto

fun ContractVerificationResponseDto.toDomainModel(): Boolean {
    return this.verifyResult
}
