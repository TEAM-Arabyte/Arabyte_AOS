package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.MyPageRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.response.ContractVerificationResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.MyInfoResponseDto
import com.konkuk.arabyte_aos.data.dataremote.service.MyPageService
import retrofit2.Response
import javax.inject.Inject

class MyPageRemoteDataSourceImpl
    @Inject
    constructor(
        private val service: MyPageService,
    ) : MyPageRemoteDataSource {
        override suspend fun getMyInfo(): Response<MyInfoResponseDto> =
            service.getMyInfo()

        override suspend fun postContractVerification(
            companyName: String,
            imageUrl: String,
        ): Response<ContractVerificationResponseDto> =
            service.postContractVerification(companyName = companyName, imageUrl = imageUrl)
    }
