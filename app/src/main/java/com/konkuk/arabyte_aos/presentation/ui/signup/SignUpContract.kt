package com.konkuk.arabyte_aos.presentation.ui.signup

import com.konkuk.arabyte_aos.presentation.type.view.SignUpType
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState


class SignUpContract {
    data class SignUpUiState(
        val loadState: LoadState = LoadState.Idle,
        val signUpType: SignUpType = SignUpType.SECOND,
        val buttonEnabled:Boolean = false,
        val selectedAge:String? =null,
        val selectedGender:String? =null
    ) : UiState

    sealed interface SignUpSideEffect : UiSideEffect {
        data object DummySideEffect : SignUpSideEffect
    }

    sealed class SignUpEvent : UiEvent {
        data object CompleteButtonClicked : SignUpEvent()
        data class AgeButtonClicked(val selectedAge:String) : SignUpEvent()
        data class GenderButtonClicked(val selectedGender:String) : SignUpEvent()

    }
}
