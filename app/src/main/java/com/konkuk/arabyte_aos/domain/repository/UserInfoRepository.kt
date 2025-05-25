package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.NicknameCheck
import com.konkuk.arabyte_aos.domain.model.UserOnboardingInfo

interface UserInfoRepository {
    fun setAccessToken(accessToken: String)

    fun getAccessToken(): String

    fun setRefreshToken(refreshToken: String)

    fun getRefreshToken(): String

    fun setUserId(userId: Int)

    fun getUserId(): Int

    suspend fun postOnboarding(userOnboardingInfo: UserOnboardingInfo): Result<Unit>

    suspend fun deleteUser(): Result<Unit>

    suspend fun getNicknameCheck(nickname: String): Result<NicknameCheck>

    fun clear()
}
