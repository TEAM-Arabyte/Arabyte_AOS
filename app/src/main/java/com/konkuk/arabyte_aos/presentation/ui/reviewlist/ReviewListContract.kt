package com.konkuk.arabyte_aos.presentation.ui.reviewlist

import com.konkuk.arabyte_aos.domain.model.ReviewItem
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class ReviewListContract {
    data class ReviewListUiState(
        val loadState: LoadState = LoadState.Idle,
        val checkFilterSelected: Boolean = false,
        val regionFilterSelected: Boolean = false,
        val categoryFilterSelected: Boolean = false,
        val listSize: Int = 10,
        val reviewList: List<ReviewItem> =
            listOf(
                ReviewItem(1, "스타벅스", true, 4.5f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...!", "서울 강남구", "외식/음료"),
                ReviewItem(2, "이마트24", false, 3.8f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "서울 송파구", "매장관리/판매"),
                ReviewItem(3, "배달의민족", true, 4.2f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "경기 성남시", "운전/배달"),
                ReviewItem(4, "카카오", true, 5.0f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "서울 서초구", "IT/기술"),
                ReviewItem(5, "학원쌤", false, 4.0f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "인천 부평구", "교육/강사"),
                ReviewItem(6, "디자인스튜디오", true, 4.7f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "서울 마포구", "디자인"),
                ReviewItem(7, "병원 간호보조", false, 3.9f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "대전 중구", "병원/간호/연구"),
                ReviewItem(8, "콜센터", false, 3.3f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "부산 해운대구", "고객상담/영업"),
                ReviewItem(9, "건설현장", true, 4.1f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "경북 구미시", "생산/건설"),
                ReviewItem(10, "행정사무보조", false, 4.4f, " 처음 카페 알바를 시작한 곳인데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 배울 수 있어서 ...", "전북 전주시", "사무직"),
            ),
    ) : UiState

    sealed interface ReviewListSideEffect : UiSideEffect {
        data object DummySideEffect : ReviewListSideEffect
    }

    sealed class ReviewListEvent : UiEvent
}
