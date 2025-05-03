package com.konkuk.arabyte_aos.presentation.ui.reviewwrite

import com.konkuk.arabyte_aos.domain.model.Overtime
import com.konkuk.arabyte_aos.domain.model.ReviewRating
import com.konkuk.arabyte_aos.domain.model.Salary
import com.konkuk.arabyte_aos.domain.model.SalaryDate
import com.konkuk.arabyte_aos.domain.model.WorkAtmosphere
import com.konkuk.arabyte_aos.domain.model.WorkDifficulty
import com.konkuk.arabyte_aos.domain.model.WorkIntensity
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import com.konkuk.arabyte_aos.presentation.util.view.TextFieldValidationState

class ReviewWriteContract {
    data class ReviewWriteUiState(
        val loadState: LoadState = LoadState.Idle,
        val companyName: String = "",
        val companyValidationState: TextFieldValidationState = TextFieldValidationState.IDLE,
        val jobCategoryList: List<ArabyteJobCategory> = emptyList(),
        val region: String = "",
        val locationId: Int = 0,
        val star: Int = 0,
        val reviewText: String = "",
        val reviewRating: ReviewRating =
            ReviewRating(
                workIntensity = WorkIntensity.LIGHT,
                workAtmosphere = WorkAtmosphere.RIGID,
                salary = Salary.AVERAGE,
                salaryDate = SalaryDate.REGULARLY,
                overtime = Overtime.SOMETIMES,
                workDifficulty = WorkDifficulty.EASY,
            ),
    ) : UiState

    sealed interface ReviewWriteSideEffect : UiSideEffect {
        data class NavigateToReviewDetail(val reviewId: Int) : ReviewWriteSideEffect
    }

    sealed class ReviewWriteEvent : UiEvent {
        data object ClickCertifiedFilterButton : ReviewWriteEvent()
    }
}
