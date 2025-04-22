package com.konkuk.arabyte_aos.presentation.ui.mypage

import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class MyPageContract {
    data class MyPageUiState(
        val loadState: LoadState = LoadState.Idle,
    ) : UiState

    sealed interface MyPageSideEffect : UiSideEffect {
        data object NavigateToLogin : MyPageSideEffect
    }

    sealed class MyPageEvent : UiEvent {
        data object WithDrawClicked : MyPageEvent()
    }
}
