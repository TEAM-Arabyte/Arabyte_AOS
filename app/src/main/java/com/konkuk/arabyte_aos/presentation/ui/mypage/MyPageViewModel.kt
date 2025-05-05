package com.konkuk.arabyte_aos.presentation.ui.mypage

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import com.konkuk.arabyte_aos.domain.usecase.user.DeleteUserUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel
    @Inject
    constructor(
        private val deleteUserUseCase: DeleteUserUseCase,
        private val userInfoRepository: UserInfoRepository,
    ) : BaseViewModel<MyPageContract.MyPageUiState, MyPageContract.MyPageSideEffect, MyPageContract.MyPageEvent>() {
        override fun createInitialState(): MyPageContract.MyPageUiState = MyPageContract.MyPageUiState()

        override suspend fun handleEvent(event: MyPageContract.MyPageEvent) {
            when (event) {
                is MyPageContract.MyPageEvent.WithDrawClicked -> withDrawClicked()

                is MyPageContract.MyPageEvent.ChangeDialogVisible -> {
                    setState { copy(dialogVisible = !currentState.dialogVisible) }
                }

                is MyPageContract.MyPageEvent.ChangeUserProfileVisible -> {
                    setState { copy(userProfileVisible = !currentState.userProfileVisible) }
                }
            }
        }

        private fun withDrawClicked() {
            setState { copy(loadState = LoadState.Loading) }
            viewModelScope.launch {
                deleteUserUseCase().onSuccess {
                    userInfoRepository.clear()
                    setState { copy(loadState = LoadState.Success) }
                    setSideEffect(MyPageContract.MyPageSideEffect.NavigateToLogin)
                }.onFailure {
                    setState { copy(loadState = LoadState.Error) }
                }
            }
        }
    }
