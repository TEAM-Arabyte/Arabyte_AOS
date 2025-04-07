package com.konkuk.arabyte_aos.presentation.ui.signup


import android.util.Log
import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.presentation.type.view.SignUpType
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
) : BaseViewModel<SignUpContract.SignUpUiState, SignUpContract.SignUpSideEffect, SignUpContract.SignUpEvent>() {
    override fun createInitialState(): SignUpContract.SignUpUiState = SignUpContract.SignUpUiState()

    override suspend fun handleEvent(event: SignUpContract.SignUpEvent) {
        when (event) {
            is SignUpContract.SignUpEvent.CompleteButtonClicked -> {
                completeButtonClicked()
            }
            is SignUpContract.SignUpEvent.AgeButtonClicked -> {
                setState { copy(selectedAge = event.selectedAge) }
            }

            is SignUpContract.SignUpEvent.GenderButtonClicked -> {
                setState { copy(selectedGender = event.selectedGender) }
            }
        }
    }

    private fun completeButtonClicked() {
        when (currentState.signUpType) {
            SignUpType.FIRST -> {
                setState { copy(signUpType = SignUpType.SECOND, buttonEnabled = false) }
            }

            SignUpType.SECOND -> {
                setState { copy(loadState = LoadState.Success) }
            }
        }
    }
}
