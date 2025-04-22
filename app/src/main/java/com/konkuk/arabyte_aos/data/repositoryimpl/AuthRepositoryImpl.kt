package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.AuthRemoteDataSource
import com.konkuk.arabyte_aos.data.mapper.todomain.toDomainModel
import com.konkuk.arabyte_aos.domain.model.Auth
import com.konkuk.arabyte_aos.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl
    @Inject
    constructor(
        private val authRemoteDataSource: AuthRemoteDataSource,
    ) : AuthRepository {
        override suspend fun getAuthToken(): Result<Auth> =
            runCatching { authRemoteDataSource.getAuthToken().toDomainModel() }

    override suspend fun patchUserInfo(nickname: String, ageRange: String, gender: String, locationId: Int): Result<Unit> =
        runCatching { authRemoteDataSource.patchUserInfo(
            nickname = nickname,
            ageRange = ageRange,
            gender = gender,
            locationId = locationId
        ) }
    }
