package com.konkuk.arabyte_aos.presentation.ui.signup

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.usecase.locations.GetDongUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetGuUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetSidoUseCase
import com.konkuk.arabyte_aos.presentation.type.view.SignUpType
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import com.konkuk.arabyte_aos.presentation.util.view.TextFieldValidationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
@Inject
constructor(
    private val getSidoUseCase: GetSidoUseCase,
    private val getGuUseCase: GetGuUseCase,
    private val getDongUseCase: GetDongUseCase,
) : BaseViewModel<SignUpContract.SignUpUiState, SignUpContract.SignUpSideEffect, SignUpContract.SignUpEvent>() {
    override fun createInitialState(): SignUpContract.SignUpUiState = SignUpContract.SignUpUiState()

    override suspend fun handleEvent(event: SignUpContract.SignUpEvent) {
        when (event) {
            is SignUpContract.SignUpEvent.CompleteButtonClicked ->
                completeButtonClicked()

            is SignUpContract.SignUpEvent.AgeButtonClicked -> {
                setState { copy(selectedAge = event.selectedAge) }
            }

            is SignUpContract.SignUpEvent.GenderButtonClicked -> {
                setState { copy(selectedGender = event.selectedGender) }
            }

            is SignUpContract.SignUpEvent.NicknameValueChanged -> {
                onNicknameValueChanged(event.nickname)
            }

            is SignUpContract.SignUpEvent.CompleteButtonEnabled -> {
                setState { copy(buttonEnabled = true) }
            }

            is SignUpContract.SignUpEvent.ChangeLocationBottomSheetVisible -> {
                setState { copy(locationBottomSheetVisible = !currentState.locationBottomSheetVisible) }
            }

            is SignUpContract.SignUpEvent.SetLocation -> {
                setState { copy(location = event.location) }
            }
            is SignUpContract.SignUpEvent.LoadSidoList -> {
                loadSidoList()
            }
            is SignUpContract.SignUpEvent.LoadGuList -> TODO()

            is SignUpContract.SignUpEvent.LoadDongList -> TODO()
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

    private fun onNicknameValueChanged(nickname: String) {
        val isValid = regex.matches(nickname)
        setState {
            copy(
                nickname = nickname,
                nicknameValidationState =
                when {
                    nickname.isEmpty() -> TextFieldValidationState.IDLE
                    isValid -> TextFieldValidationState.VALID
                    else -> TextFieldValidationState.INVALID
                },
                buttonEnabled = isValid,
            )
        }
    }

    private fun loadSidoList(){
        viewModelScope.launch {
            getSidoUseCase().onSuccess { sidoList ->
                setState { copy(sidoList = sidoList) }
                Log.d("zz", "sidoList from useCase: $sidoList")
            }
                .onFailure { e->
                    Log.e("zz", "실패 발생!! 이유: ${e.message}", e)

                }
        }
    }

    companion object {
        private const val REGEX_PATTERN = "^[가-힣0-9]{1,10}$"
        val regex = Regex(REGEX_PATTERN)
    }
}
