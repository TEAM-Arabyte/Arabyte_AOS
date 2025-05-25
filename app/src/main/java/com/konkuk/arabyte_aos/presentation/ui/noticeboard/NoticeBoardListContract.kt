package com.konkuk.arabyte_aos.presentation.ui.noticeboard

import com.konkuk.arabyte_aos.domain.model.NoticeBoardContent
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteNoticeBoardCategoryType
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class NoticeBoardListContract {
    data class NoticeBoardListUiState(
        val loadState: LoadState = LoadState.Idle,
        val selectedCategory: ArabyteNoticeBoardCategoryType = ArabyteNoticeBoardCategoryType.ALL,
        val noticeBoardCount: Int = 0,
        val noticeBoardList: List<NoticeBoardContent> = emptyList(),
    ) : UiState

    sealed interface NoticeBoardListSideEffect : UiSideEffect {
        data class NavigateToNoticeBoardDetail(val articleId: Long) : NoticeBoardListSideEffect
    }

    sealed class NoticeBoardListUiEvent : UiEvent {
        data class SelectCategory(val noticeBoardCategoryType: ArabyteNoticeBoardCategoryType) : NoticeBoardListUiEvent()

        data class GetNoticeBoardList(val noticeBoardCategoryType: ArabyteNoticeBoardCategoryType) : NoticeBoardListUiEvent()
    }
}
