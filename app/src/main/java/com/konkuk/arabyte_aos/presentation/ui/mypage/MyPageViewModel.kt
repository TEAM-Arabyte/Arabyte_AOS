package com.konkuk.arabyte_aos.presentation.ui.mypage

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.konkuk.arabyte_aos.domain.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.domain.model.Contract
import com.konkuk.arabyte_aos.domain.model.MyContract
import com.konkuk.arabyte_aos.domain.repository.UserInfoRepository
import com.konkuk.arabyte_aos.domain.usecase.mypage.GetMyInfoUseCase
import com.konkuk.arabyte_aos.domain.usecase.mypage.PostContractVerificationUseCase
import com.konkuk.arabyte_aos.domain.usecase.user.DeleteUserUseCase
import com.konkuk.arabyte_aos.presentation.model.Gender
import com.konkuk.arabyte_aos.presentation.model.UserProfile
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel
@Inject
constructor(
    private val deleteUserUseCase: DeleteUserUseCase,
    private val userInfoRepository: UserInfoRepository,
    private val getMyInfoUseCase: GetMyInfoUseCase,
    private val postContractVerificationUseCase: PostContractVerificationUseCase
) : BaseViewModel<MyPageContract.MyPageUiState, MyPageContract.MyPageSideEffect, MyPageContract.MyPageEvent>() {
    override fun createInitialState(): MyPageContract.MyPageUiState = MyPageContract.MyPageUiState()

    override suspend fun handleEvent(event: MyPageContract.MyPageEvent) {
        when (event) {
            is MyPageContract.MyPageEvent.WithDrawClicked -> withDrawClicked()

            is MyPageContract.MyPageEvent.ChangeDialogVisible -> {
                setState { copy(dialogVisible = !currentState.dialogVisible) }
            }

            is MyPageContract.MyPageEvent.ChangeUserProfileVisible -> {
                setState { copy(userProfileVisible = !currentState.userProfileVisible) }
            }

            is MyPageContract.MyPageEvent.LogoutClicked -> logout()

            is MyPageContract.MyPageEvent.SetWebViewUrl -> {
                setState { copy(wevViewUrl = event.url) }
            }

            is MyPageContract.MyPageEvent.ChangeWebViewVisible -> {
                setState { copy(webViewVisible = !currentState.webViewVisible) }
            }

            is MyPageContract.MyPageEvent.GetMyInfo -> getMyInfo()

            is MyPageContract.MyPageEvent.ChangeAddContractViewVisible -> setState { copy(addContractViewVisible = !currentState.addContractViewVisible) }

            is MyPageContract.MyPageEvent.ChangeMyContractViewVisible -> setState { copy(myContractViewVisible = !currentState.myContractViewVisible) }

            is MyPageContract.MyPageEvent.CompanyNameValueChanged -> onCompanyNameChanged(event.companyName)

            is MyPageContract.MyPageEvent.EnrollContract -> postEnrollContract()

            is MyPageContract.MyPageEvent.GalleryPickButtonClicked -> TODO()

            is MyPageContract.MyPageEvent.SetContractImageUrl -> setState { copy(contractImageUri = event.url) }
        }
    }

    private fun withDrawClicked() {
        setState { copy(loadState = LoadState.Loading) }
        viewModelScope.launch {
            deleteUserUseCase().onSuccess {
                setState { copy(loadState = LoadState.Success) }
                logout()
            }.onFailure {
                setState { copy(loadState = LoadState.Error) }
            }
        }
    }

    private fun logout() {
        userInfoRepository.clear()
        setSideEffect(MyPageContract.MyPageSideEffect.NavigateToLogin)
    }

    private fun getMyInfo() {
        viewModelScope.launch {
            getMyInfoUseCase().onSuccess { myInfo ->
                setState {
                    copy(userProfile = UserProfile(
                        userName = myInfo.userName,
                        location = myInfo.location,
                        age = myInfo.age,
                        gender = Gender.fromLabel(myInfo.gender),
                        experienceYears = myInfo.experienceYears,
                        experienceMonths = myInfo.experienceMonths,
                        jobInterests = myInfo.jobInterests.mapNotNull { ArabyteJobCategory.fromName(it) }))
                }
            }
        }
    }

    private fun onCompanyNameChanged(companyName: String) {
        val trimmed = companyName.take(10)
        setState { copy(companyName = trimmed) }
    }

    private fun postEnrollContract(){
        viewModelScope.launch {
            postContractVerificationUseCase(
                companyName = currentState.companyName,
                imageUrl = currentState.contractImageUri
            ).onSuccess {
                addContract(currentState.companyName)
                setState { copy(companyName = "", addContractViewVisible = false, contractImageUri = "") }
            }.onFailure {
                setState { copy(companyName = "", addContractViewVisible = false, contractImageUri = "") }
            }
        }
    }

    private fun addContract(companyName: String){
        val newContract = MyContract(companyName = companyName, valid = true)

        viewModelScope.launch {
            val updatedList = currentState.myContractList + newContract
            setState { copy(myContractList = updatedList) }
        }
    }
}
