package com.konkuk.arabyte_aos.presentation.ui.noticeboard

import com.konkuk.arabyte_aos.domain.model.NoticeBoardItem
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
        val noticeBoardList: List<NoticeBoardItem> =
            listOf(
                NoticeBoardItem(noticeBoardItemId = 1, title = "최악의 알바 후기.. 다들 조심하세요!", text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.FREE, isLiked = true),
                NoticeBoardItem(noticeBoardItemId = 2, title = "최악의 알바 후기.. 다들 조심하세요!", text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.INFO, isLiked = false),
                NoticeBoardItem(noticeBoardItemId = 3, title = "최고 알바의 알바후기닷!! 다들 하세요!", text = "정말로 재밋었어요.", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.INFO, isLiked = false),
                NoticeBoardItem(noticeBoardItemId = 4, title = "최악의 알바 후기.. 다들 조심하세요!", text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.ALL, isLiked = true),
                NoticeBoardItem(noticeBoardItemId = 5, title = "최악의 알바 후기.. 다들 조심하세요!", text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.INFO, isLiked = false),
                NoticeBoardItem(noticeBoardItemId = 6, title = "최고 알바의 알바후기닷!! 다들 하세요!", text = "정말로 재밋었어요.", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.ALL, isLiked = false),
            ),
    ) : UiState

    sealed interface NoticeBoardListSideEffect : UiSideEffect {
        data class NavigateToNoticeBoardDetail(val itemId: Int) : NoticeBoardListSideEffect
    }

    sealed class NoticeBoardListUiEvent : UiEvent {
        data class SelectCategory(val noticeBoardCategoryType: ArabyteNoticeBoardCategoryType) : NoticeBoardListUiEvent()

        data class LoadNoticeBoardList(val noticeBoardCategoryType: ArabyteNoticeBoardCategoryType) : NoticeBoardListUiEvent()
    }
}
