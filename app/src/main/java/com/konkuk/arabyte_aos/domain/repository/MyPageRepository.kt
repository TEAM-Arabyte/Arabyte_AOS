package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.MyInfo

interface MyPageRepository {
    suspend fun getMyInfo(): Result<MyInfo>

    suspend fun postContractVerification(companyName: String, imageUrl: String): Result<Boolean>
}
