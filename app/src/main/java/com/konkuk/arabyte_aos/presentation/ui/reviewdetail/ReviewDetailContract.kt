package com.konkuk.arabyte_aos.presentation.ui.reviewdetail

import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class ReviewDetailContract {
    data class ReviewDetailUiState(
        val loadState: LoadState = LoadState.Idle,
    ) : UiState

    sealed interface ReviewDetailSideEffect : UiSideEffect {
        data object DummySideEffect : ReviewDetailSideEffect
    }

    sealed class ReviewDetailEvent : UiEvent {
        data object DummyEvent : ReviewDetailEvent()
    }
}
