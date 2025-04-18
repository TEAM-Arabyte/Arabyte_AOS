package com.konkuk.arabyte_aos.presentation.ui.login

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
    @Inject
    constructor(
        private val userInfoRepository: UserInfoRepository,
    ) : BaseViewModel<LoginContract.LoginUiState, LoginContract.LoginSideEffect, LoginContract.LoginEvent>() {
        override fun createInitialState(): LoginContract.LoginUiState = LoginContract.LoginUiState()

        override suspend fun handleEvent(event: LoginContract.LoginEvent) {
            when (event) {
                is LoginContract.LoginEvent.SetAuthToken -> setState { copy(authTokenLoadState = event.authTokenLoadState) }
                is LoginContract.LoginEvent.GetLogin -> setState { copy(loadState = event.loadState) }
            }
        }

        fun setKakaoAccessToken(accessToken: String) {
            userInfoRepository.setAccessToken(accessToken)
            DebugLog.d("SetKakaoAccessToken", "accessToken= $accessToken")
            setEvent(LoginContract.LoginEvent.SetAuthToken(authTokenLoadState = LoadState.Success))
        }

        fun getLogin() {
            viewModelScope.launch {
                setEvent(LoginContract.LoginEvent.GetLogin(loadState = LoadState.Success))
            }
        }

        fun checkAutoLogin() {
            if (userInfoRepository.getRefreshToken()
                    .isNotEmpty()
            ) {
                setEvent(LoginContract.LoginEvent.GetLogin(LoadState.Success))
            } else {
                DebugLog.d("Login ViewModel", "Local Token is Empty")
            }
        }
    }
