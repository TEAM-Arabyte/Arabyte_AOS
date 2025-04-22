package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.Auth
import com.konkuk.arabyte_aos.domain.model.RegisterUserInfo

interface AuthRepository {
    suspend fun getAuthToken(): Result<Auth>

    suspend fun patchUserInfo(registerUserInfo: RegisterUserInfo): Result<Unit>
}
