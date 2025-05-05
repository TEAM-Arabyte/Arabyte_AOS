package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import com.konkuk.arabyte_aos.presentation.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class NoticeBoardDetailContract {
    data class NoticeBoardDetailUiState(
        val loadState: LoadState = LoadState.Idle,
        val noticeBoardDetail: NoticeBoardDetail? = null,
    ) : UiState

    sealed interface NoticeBoardDetailSideEffect : UiSideEffect {
        data object DummySideEffect : NoticeBoardDetailSideEffect
    }

    sealed class NoticeBoardDetailEvent : UiEvent {
        data class GetNoticeBoardDetail(val articleId: Long) : NoticeBoardDetailEvent()
    }
}
