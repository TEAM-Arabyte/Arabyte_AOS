package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.AuthRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.request.PatchUserInfoRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.AuthResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.PatchUserInfoResponseDto
import com.konkuk.arabyte_aos.data.dataremote.service.AuthService
import javax.inject.Inject

class AuthRemoteDataSourceImpl
@Inject
constructor(
    private val service: AuthService,
) : AuthRemoteDataSource {
    override suspend fun getAuthToken(): AuthResponseDto = service.getAuthToken()

    override suspend fun patchUserInfo(registerRequestDto: PatchUserInfoRequestDto): PatchUserInfoResponseDto = service.patchUserInfo(
        registerRequestDto = registerRequestDto
    )
}
