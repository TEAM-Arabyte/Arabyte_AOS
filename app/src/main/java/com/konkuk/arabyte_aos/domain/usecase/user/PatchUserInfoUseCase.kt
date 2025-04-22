package com.konkuk.arabyte_aos.domain.usecase.user

import com.konkuk.arabyte_aos.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PatchUserInfoUseCase
@Inject
constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(nickname: String, ageRange: String, gender: String, locationId: Int): Result<Unit> {
        return authRepository.patchUserInfo(
            nickname = nickname,
            ageRange = ageRange,
            gender = gender,
            locationId = locationId
        )
    }
}
