package com.konkuk.arabyte_aos.domain.usecase.user

import com.konkuk.arabyte_aos.domain.model.UserOnboardingInfo
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostOnboardingUserInfoUseCase
    @Inject
    constructor(
        private val userInfoRepository: UserInfoRepository,
    ) {
        suspend operator fun invoke(userOnboardingInfo: UserOnboardingInfo): Result<Unit> {
            return userInfoRepository.postOnboarding(
                userOnboardingInfo = userOnboardingInfo,
            )
        }
    }
