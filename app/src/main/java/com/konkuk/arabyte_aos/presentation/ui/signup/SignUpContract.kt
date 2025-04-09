package com.konkuk.arabyte_aos.presentation.ui.signup

import com.konkuk.arabyte_aos.presentation.type.view.SignUpType
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import com.konkuk.arabyte_aos.presentation.util.view.TextFieldValidationState

class SignUpContract {
    data class SignUpUiState(
        val loadState: LoadState = LoadState.Idle,
        val signUpType: SignUpType = SignUpType.FIRST,
        val buttonEnabled: Boolean = false,
        val selectedAge: String? = null,
        val selectedGender: String? = null,
        val nickname: String = "",
        val nicknameValidationState: TextFieldValidationState = TextFieldValidationState.IDLE,
        val locationBottomSheetVisible: Boolean = false,
        val location: String = "",
    ) : UiState

    sealed interface SignUpSideEffect : UiSideEffect {
        data object DummySideEffect : SignUpSideEffect
    }

    sealed class SignUpEvent : UiEvent {
        data object CompleteButtonClicked : SignUpEvent()

        data class AgeButtonClicked(val selectedAge: String) : SignUpEvent()

        data class GenderButtonClicked(val selectedGender: String) : SignUpEvent()

        data class NicknameValueChanged(val nickname: String) : SignUpEvent()

        data object CompleteButtonEnabled : SignUpEvent()

        data object ChangeLocationBottomSheetVisible : SignUpEvent()

        data class SetLocation(val location: String) : SignUpEvent()
    }
}
