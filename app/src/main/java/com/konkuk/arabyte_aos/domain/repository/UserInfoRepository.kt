package com.konkuk.arabyte_aos.domain.repository

interface UserInfoRepository {
    fun setAccessToken(accessToken: String)

    fun getAccessToken(): String

    fun setRefreshToken(refreshToken: String)

    fun getRefreshToken(): String

    fun clear()
}
