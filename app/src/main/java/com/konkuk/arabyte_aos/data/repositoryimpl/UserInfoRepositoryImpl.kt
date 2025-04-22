package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.datalocal.datasource.UserInfoLocalDataSource
import com.konkuk.arabyte_aos.data.dataremote.datasource.UserRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todata.toData
import com.konkuk.arabyte_aos.domain.model.UserOnboardingInfo
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl
    @Inject
    constructor(
        private val userInfoLocalDataSource: UserInfoLocalDataSource,
        private val useInfoRemoteDataSource: UserRemoteDataSource,
    ) : UserInfoRepository {
        override fun setAccessToken(accessToken: String) {
            userInfoLocalDataSource.accessToken = accessToken
        }

        override fun getAccessToken(): String = userInfoLocalDataSource.accessToken

        override fun setRefreshToken(refreshToken: String) {
            userInfoLocalDataSource.refreshToken = refreshToken
        }

        override fun getRefreshToken(): String = userInfoLocalDataSource.refreshToken

        override suspend fun postOnboarding(userOnboardingInfo: UserOnboardingInfo): Result<Unit> =
            runCatching {
                useInfoRemoteDataSource.postOnboarding(
                    postOnboardingRequestDto = userOnboardingInfo.toData(),
                )
            }

        override suspend fun deleteUser(): Result<Unit> =
            kotlin.runCatching {
                useInfoRemoteDataSource.deleteUser()
            }

        override fun clear() {
            userInfoLocalDataSource.clear()
        }
    }
