package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.response.ContractVerificationResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.MyInfoResponseDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.MYPAGE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MyPageService {
    @GET("/$MYPAGE/info")
    suspend fun getMyInfo(): Response<MyInfoResponseDto>

    @POST("/$MYPAGE/contract")
    suspend fun postContractVerification(
        @Query("companyName") companyName: String,
        @Query("imageUrl") imageUrl: String,
    ): Response<ContractVerificationResponseDto>
}
