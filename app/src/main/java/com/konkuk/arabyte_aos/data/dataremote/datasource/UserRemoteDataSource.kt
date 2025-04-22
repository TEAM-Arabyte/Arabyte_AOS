package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostOnboardingRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetCheckNicknameResponseDto
import retrofit2.Response

interface UserRemoteDataSource {
    suspend fun postOnboarding(postOnboardingRequestDto: PostOnboardingRequestDto)

    suspend fun deleteUser()

    suspend fun getNicknameCheck(nickname: String): Response<GetCheckNicknameResponseDto>
}
