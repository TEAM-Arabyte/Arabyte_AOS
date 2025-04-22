package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostOnboardingRequestDto

interface UserRemoteDataSource {
    suspend fun postOnboarding(postOnboardingRequestDto: PostOnboardingRequestDto) : Unit
}
