package com.konkuk.arabyte_aos.domain.usecase.user

import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteUserUseCase
    @Inject
    constructor(
        private val userRepository: UserInfoRepository,
    ) {
        suspend operator fun invoke(): Result<Unit> {
            return userRepository.deleteUser()
        }
    }
