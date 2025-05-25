package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.response.ContractVerificationResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.MyInfoResponseDto
import retrofit2.Response

interface MyPageRemoteDataSource {
    suspend fun getMyInfo(): Response<MyInfoResponseDto>

    suspend fun postContractVerification(
        companyName: String,
        imageUrl: String,
    ): Response<ContractVerificationResponseDto>
}
