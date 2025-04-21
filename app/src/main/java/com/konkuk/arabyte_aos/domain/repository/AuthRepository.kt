package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.Auth

interface AuthRepository {
    suspend fun getAuthToken(): Result<Auth>
}
