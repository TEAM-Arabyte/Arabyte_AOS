package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.datalocal.datasource.UserInfoLocalDataSource
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl
    @Inject
    constructor(
        private val userInfoLocalDataSource: UserInfoLocalDataSource,
    ) : UserInfoRepository {
        override fun setAccessToken(accessToken: String) {
            userInfoLocalDataSource.accessToken = accessToken
        }

        override fun getAccessToken(): String = userInfoLocalDataSource.accessToken

        override fun setRefreshToken(refreshToken: String) {
            userInfoLocalDataSource.refreshToken = refreshToken
        }

        override fun getRefreshToken(): String = userInfoLocalDataSource.refreshToken

        override fun clear() {
            userInfoLocalDataSource.clear()
        }
    }
