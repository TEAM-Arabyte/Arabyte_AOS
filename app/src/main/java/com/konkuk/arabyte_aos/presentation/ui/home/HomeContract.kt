package com.konkuk.arabyte_aos.presentation.ui.home

import com.konkuk.arabyte_aos.domain.model.NoticeBoardItem
import com.konkuk.arabyte_aos.domain.model.ReviewItem
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteNoticeBoardCategoryType
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class HomeContract {
    data class HomeUiState(
        val loadState: LoadState = LoadState.Idle,
        val userName: String = "어쩔티비",
        val region: String = "서울특별시 강남구 개포2동",
        val reviewList: List<ReviewItem> =
            listOf(
                ReviewItem(1, "스타벅스", true, 4.5f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...!", "서울 강남구", category = ArabyteJobCategory.FOOD_BEVERAGE),
                ReviewItem(2, "이마트24", false, 3.8f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "서울 송파구", category = ArabyteJobCategory.DESIGN),
                ReviewItem(3, "배달의민족", true, 4.2f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "경기 성남시", category = ArabyteJobCategory.DELIVERY),
            ),
        val noticeBoardItem: List<NoticeBoardItem> =
            listOf(
                NoticeBoardItem(noticeBoardItemId = 1, title = "최악의 알바 후기.. 다들 조심하세요!", text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.FREE, isLiked = true),
                NoticeBoardItem(noticeBoardItemId = 2, title = "최악의 알바 후기.. 다들 조심하세요!", text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.INFO, isLiked = false),
                NoticeBoardItem(noticeBoardItemId = 3, title = "최고 알바의 알바후기닷!! 다들 하세요!", text = "정말로 재밋었어요.", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.INFO, isLiked = false),
                NoticeBoardItem(noticeBoardItemId = 4, title = "최악의 알바 후기.. 다들 조심하세요!", text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.FREE, isLiked = true),
                NoticeBoardItem(noticeBoardItemId = 5, title = "최악의 알바 후기.. 다들 조심하세요!", text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.INFO, isLiked = false),
                NoticeBoardItem(noticeBoardItemId = 6, title = "최고 알바의 알바후기닷!! 다들 하세요!", text = "정말로 재밋었어요.", likeCount = 5, commentCount = 5, uploadAt = "10분 전", thumbnailImage = "", noticeBoardCategoryType = ArabyteNoticeBoardCategoryType.INFO, isLiked = false),
            ),
    ) : UiState

    sealed interface HomeSideEffect : UiSideEffect {
        data class NavigateToReviewCategory(val categoryType: ArabyteCategoryType) : HomeSideEffect

        data object NavigateToReviewList : HomeSideEffect

        data class NavigateToReviewDetail(val reviewId: Int) : HomeSideEffect

        data object NavigateToNoticeBoard : HomeSideEffect

        data class NavigateToNoticeBoardDetail(val noticeBoardId: Int) : HomeSideEffect

        data object NavigateToMyPage : HomeSideEffect
    }

    sealed class HomeEvent : UiEvent {
        data object LoadUserName : HomeEvent()

        data object LoadRegion : HomeEvent()

        data object LoadReviewList : HomeEvent()

        data object LoadNoticeBoardList : HomeEvent()
    }
}
