package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.Auth
import com.konkuk.arabyte_aos.domain.model.LocationData

interface AuthRepository {
    suspend fun getAuthToken(): Result<Auth>
}
