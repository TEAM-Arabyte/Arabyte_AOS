package com.konkuk.arabyte_aos.presentation.ui.login

import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class LoginContract {
    data class LoginUiState(
        val loadState: LoadState = LoadState.Idle,
        val authTokenLoadState: LoadState = LoadState.Idle,
    ) : UiState

    sealed interface LoginSideEffect : UiSideEffect {
        data object NavigateToSignUp : LoginSideEffect

        data object NavigateToHome : LoginSideEffect
    }

    sealed class LoginEvent : UiEvent {
        data class SetAuthToken(val authTokenLoadState: LoadState) : LoginEvent()

        data class GetLogin(val loadState: LoadState) : LoginEvent()
    }
}
