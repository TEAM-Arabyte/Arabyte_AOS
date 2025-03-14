package com.konkuk.arabyte_aos.data.datalocal.datasource

interface UserInfoLocalDataSource {
    var accessToken: String
    var refreshToken: String

    fun clear()
}
