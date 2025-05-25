package com.konkuk.arabyte_aos.presentation.ui.mypage

import com.konkuk.arabyte_aos.domain.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.domain.model.MyContract
import com.konkuk.arabyte_aos.presentation.model.Gender
import com.konkuk.arabyte_aos.presentation.model.UserProfile
import com.konkuk.arabyte_aos.presentation.util.WebViewUrl.SERVICE_RULES_URL
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
        val webViewVisible: Boolean = false,
        val myContractViewVisible: Boolean = false,
        val addContractViewVisible: Boolean = false,
        val myContractList: List<MyContract> = emptyList(),
        val companyName: String = "",
        val contractImageUri: String = "",
        val wevViewUrl: String = SERVICE_RULES_URL,
        val contractUploadState: LoadState = LoadState.Idle
    ) : UiState

    sealed interface MyPageSideEffect : UiSideEffect {
        data object NavigateToLogin : MyPageSideEffect

        data object ShowImageErrorToast : MyPageSideEffect
    }

    sealed class MyPageEvent : UiEvent {
        data object WithDrawClicked : MyPageEvent()

        data object LogoutClicked : MyPageEvent()

        data object ChangeDialogVisible : MyPageEvent()

        data object ChangeUserProfileVisible : MyPageEvent()

        data object ChangeWebViewVisible : MyPageEvent()

        data object ChangeMyContractViewVisible : MyPageEvent()

        data object ChangeAddContractViewVisible : MyPageEvent()

        data class SetWebViewUrl(val url: String) : MyPageEvent()

        data object GetMyInfo : MyPageEvent()

        data class CompanyNameValueChanged(val companyName: String) : MyPageEvent()

        data object EnrollContract : MyPageEvent()

        data class SetContractImageUrl(val url: String) : MyPageEvent()
    }
}
