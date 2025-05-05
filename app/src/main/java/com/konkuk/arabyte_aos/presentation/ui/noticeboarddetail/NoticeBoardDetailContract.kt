package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class NoticeBoardDetailContract {
    data class NoticeBoardDetailUiState(
        val loadState: LoadState = LoadState.Idle,
        val noticeBoardDetail: NoticeBoardDetail =
            NoticeBoardDetail(
                articleId = -1,
                nickname = "",
                createdAt = "",
                title = "",
                text = "",
                likeCount = 0,
                commentCount = 0,
                comments = emptyList(),
                imageUrls = emptyList(),
                isLiked = false,
            ),
    ) : UiState

    sealed interface NoticeBoardDetailSideEffect : UiSideEffect {
        data object DummySideEffect : NoticeBoardDetailSideEffect
    }

    sealed class NoticeBoardDetailEvent : UiEvent {
        data class GetNoticeBoardDetail(val articleId: Long) : NoticeBoardDetailEvent()
    }
}
