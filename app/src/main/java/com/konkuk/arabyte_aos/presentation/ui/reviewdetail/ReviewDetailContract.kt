package com.konkuk.arabyte_aos.presentation.ui.reviewdetail

import com.konkuk.arabyte_aos.domain.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.domain.model.Overtime
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.model.ReviewHelpfulType
import com.konkuk.arabyte_aos.domain.model.ReviewRating
import com.konkuk.arabyte_aos.domain.model.Salary
import com.konkuk.arabyte_aos.domain.model.SalaryDate
import com.konkuk.arabyte_aos.domain.model.WorkAtmosphere
import com.konkuk.arabyte_aos.domain.model.WorkDifficulty
import com.konkuk.arabyte_aos.domain.model.WorkIntensity
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class ReviewDetailContract {
    data class ReviewDetailUiState(
        val loadState: LoadState = LoadState.Idle,
        val currentUserId: Int = -1,
        val reviewDetail: ReviewDetail =
            ReviewDetail(
                reviewId = -1,
                userId = -1,
                companyName = "",
                isCertified = false,
                star = 0,
                region = "",
                category = ArabyteJobCategory.FOOD_BEVERAGE,
                reviewRating =
                    ReviewRating(
                        workIntensity = WorkIntensity.LIGHT,
                        workAtmosphere = WorkAtmosphere.RIGID,
                        salary = Salary.HIGH,
                        salaryDate = SalaryDate.REGULARLY,
                        overtime = Overtime.REGULARLY,
                        workDifficulty = WorkDifficulty.EASY,
                    ),
                reviewContent = "",
                badCount = 0,
                normalCount = 0,
                goodCount = 0,
                helpful = null,
            ),
        val dialogVisible: Boolean = false,
    ) : UiState

    sealed interface ReviewDetailSideEffect : UiSideEffect {
        data object PopBackStack : ReviewDetailSideEffect

        data object NavigateToReviewList : ReviewDetailSideEffect

        data object ShowServerErrorToast : ReviewDetailSideEffect

        data object ShowAlertToast : ReviewDetailSideEffect
    }

    sealed class ReviewDetailEvent : UiEvent {
        data class GetReviewDetail(val reviewId: Int) : ReviewDetailEvent()

        data object GetUserID : ReviewDetailEvent()

        data object ChangeDialogVisible : ReviewDetailEvent()

        data class DialogCompleteButtonClicked(val isMyReview: Boolean) : ReviewDetailEvent()

        data class ReviewHelpfulClicked(val isMyReview: Boolean, val reviewHelpful: ReviewHelpfulType) : ReviewDetailEvent()
    }
}
