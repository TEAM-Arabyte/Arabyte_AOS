package com.konkuk.arabyte_aos.presentation.ui.mypage

import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.model.Gender
import com.konkuk.arabyte_aos.presentation.model.UserProfile
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class MyPageContract {
    data class MyPageUiState(
        val loadState: LoadState = LoadState.Idle,
        val dialogVisible: Boolean = false,
        val userProfileVisible: Boolean = false,
        val userProfile: UserProfile =
            UserProfile(
                userName = "나야 알바",
                location = "서울특별시 강남구",
                age = "20대 초반",
                gender = Gender.FEMALE,
                experienceYears = 3,
                experienceMonths = 4,
                jobInterests = listOf(ArabyteJobCategory.DELIVERY, ArabyteJobCategory.FOOD_BEVERAGE),
            ),
    ) : UiState

    sealed interface MyPageSideEffect : UiSideEffect {
        data object NavigateToLogin : MyPageSideEffect
    }

    sealed class MyPageEvent : UiEvent {
        data object WithDrawClicked : MyPageEvent()

        data object LogoutClicked : MyPageEvent()

        data object ChangeDialogVisible : MyPageEvent()

        data object ChangeUserProfileVisible : MyPageEvent()
    }
}
