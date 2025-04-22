package com.konkuk.arabyte_aos.presentation.ui.signup

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.usecase.locations.GetDongUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetGuUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetSidoUseCase
import com.konkuk.arabyte_aos.domain.usecase.user.PatchUserInfoUseCase
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
    private val patchUserInfoUseCase: PatchUserInfoUseCase
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

            is SignUpContract.SignUpEvent.LoadSidoList -> loadSidoList()

            is SignUpContract.SignUpEvent.LoadGuList -> loadGuList(sidoCode = event.sidoCode)

            is SignUpContract.SignUpEvent.LoadDongList -> loadDongList(sidoCode = event.sidoCode, guCode = event.guCode)

            is SignUpContract.SignUpEvent.SelectSido -> selectSido(event.sido)

            is SignUpContract.SignUpEvent.SelectGu -> selectGu(event.gu)

            is SignUpContract.SignUpEvent.SelectDong -> selectDong(event.dong)
        }
    }

    private fun completeButtonClicked() {
        when (currentState.signUpType) {
            SignUpType.FIRST -> {

                setState { copy(signUpType = SignUpType.SECOND, buttonEnabled = false) }
            }

            SignUpType.SECOND -> {
                setState { copy(loadState = LoadState.Loading) }
                viewModelScope.launch {
                    patchUserInfoUseCase(
                        nickname = currentState.nickname,
                        ageRange = currentState.selectedAge!!,
                        gender = currentState.selectedGender!!,
                        locationId = (
                                currentState.selectedDong?.id
                                    ?: currentState.selectedGu?.id
                                    ?: currentState.selectedSido?.id
                                )!!
                    ).onSuccess {
                        setState { copy(loadState = LoadState.Success) }
                    }.onFailure {
                            setState { copy(loadState = LoadState.Error) }
                        }
                }
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

    private fun loadSidoList() {
        viewModelScope.launch {
            getSidoUseCase().onSuccess { sidoList ->
                setState { copy(sidoList = sidoList) }
            }.onFailure { e ->
                Log.e("GetSidoUseCase", "Error: ${e.message}", e)
            }
        }
    }

    private fun selectSido(sido: LocationData) {
        loadGuList(sidoCode = sido.sidoCode)
        setState { copy(selectedSido = sido, dongList = emptyList(), selectedGu = null, selectedDong = null) }
    }

    private fun loadGuList(sidoCode: String) {
        viewModelScope.launch {
            getGuUseCase(sidoCode = sidoCode).onSuccess { guList ->
                setState { copy(guList = guList) }
            }.onFailure { e ->
                Log.e("GetGuUseCase", "Error: ${e.message}", e)
            }
        }
    }

    private fun selectGu(gu: LocationData) {
        loadDongList(sidoCode = gu.sidoCode, guCode = gu.guCode)
        setState { copy(selectedGu = gu, dongList = emptyList(), selectedDong = null) }
    }

    private fun loadDongList(
        sidoCode: String,
        guCode: String,
    ) {
        viewModelScope.launch {
            getDongUseCase(sidoCode = sidoCode, guCode = guCode).onSuccess { dongList ->
                setState { copy(dongList = dongList) }
            }.onFailure { e ->
                Log.e("GetDongUseCase", "Error: ${e.message}", e)
            }
        }
    }

    private fun selectDong(dong: LocationData) {
        setState { copy(selectedDong = dong) }
    }

    companion object {
        private const val REGEX_PATTERN = "^[가-힣0-9]{1,10}$"
        val regex = Regex(REGEX_PATTERN)
    }
}
