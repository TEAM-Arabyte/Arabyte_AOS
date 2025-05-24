package com.konkuk.arabyte_aos.presentation.ui.home

import com.konkuk.arabyte_aos.domain.model.NoticeBoardContent
import com.konkuk.arabyte_aos.domain.model.ReviewItem
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class HomeContract {
    data class HomeUiState(
        val loadState: LoadState = LoadState.Idle,
        val userName: String = "어쩔티비",
        val region: String = "서울특별시 강남구 개포2동",
        val reviewList: List<ReviewItem> = emptyList(),
        val noticeBoardItem: List<NoticeBoardContent> = emptyList(),
    ) : UiState

    sealed interface HomeSideEffect : UiSideEffect {
        data class NavigateToReviewCategory(val categoryType: ArabyteCategoryType) : HomeSideEffect

        data object NavigateToReviewList : HomeSideEffect

        data class NavigateToReviewDetail(val reviewId: Int) : HomeSideEffect

        data object NavigateToNoticeBoard : HomeSideEffect

        data class NavigateToNoticeBoardDetail(val articleId: Long) : HomeSideEffect

        data object NavigateToMyPage : HomeSideEffect
    }

    sealed class HomeEvent : UiEvent {
        data object LoadUserName : HomeEvent()

        data object LoadRegion : HomeEvent()

        data object LoadReviewList : HomeEvent()

        data object LoadNoticeBoardList : HomeEvent()
    }
}
