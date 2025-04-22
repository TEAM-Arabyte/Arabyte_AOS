package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.UserRemoteDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostOnboardingRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetCheckNicknameResponseDto
import com.konkuk.arabyte_aos.data.dataremote.service.UserService
import retrofit2.Response
import javax.inject.Inject

class UserRemoteDataSourceImpl
@Inject
constructor(
    private val service: UserService,
) : UserRemoteDataSource {
    override suspend fun postOnboarding(postOnboardingRequestDto: PostOnboardingRequestDto) =
        service.postOnboarding(
            onboardingRequestDto = postOnboardingRequestDto,
        )

    override suspend fun deleteUser() = service.deleteUser()

    override suspend fun getNicknameCheck(nickname: String): Response<GetCheckNicknameResponseDto> = service.getCheckNickname(nickname = nickname)

}
