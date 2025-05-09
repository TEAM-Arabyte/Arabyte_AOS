package com.konkuk.arabyte_aos.data.datalocal.datasource

interface UserInfoLocalDataSource {
    var accessToken: String
    var refreshToken: String
    var userId: String

    fun clear()
}
