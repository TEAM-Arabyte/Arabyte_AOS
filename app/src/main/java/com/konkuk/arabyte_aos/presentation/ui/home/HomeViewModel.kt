package com.konkuk.arabyte_aos.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.model.NoticeBoardList
import com.konkuk.arabyte_aos.domain.model.ReviewList
import com.konkuk.arabyte_aos.domain.usecase.home.GetHomeNoticeBoardsUseCase
import com.konkuk.arabyte_aos.domain.usecase.home.GetHomeReviewsUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getHomeReviewsUseCase: GetHomeReviewsUseCase,
        private val getHomeNoticeBoardsUseCase: GetHomeNoticeBoardsUseCase,
    ) : BaseViewModel<HomeContract.HomeUiState, HomeContract.HomeSideEffect, HomeContract.HomeEvent>() {
        override fun createInitialState(): HomeContract.HomeUiState = HomeContract.HomeUiState()

        override suspend fun handleEvent(event: HomeContract.HomeEvent) {
            when (event) {
                is HomeContract.HomeEvent.LoadNoticeBoardList -> loadNoticeBoardList()
                is HomeContract.HomeEvent.LoadRegion -> loadRegion()
                is HomeContract.HomeEvent.LoadReviewList -> loadReviewList()
                is HomeContract.HomeEvent.LoadUserName -> loadUserName()
            }
        }

        private fun loadNoticeBoardList() {
            viewModelScope.launch {
                val result: Result<NoticeBoardList> = getHomeNoticeBoardsUseCase()
                result.onSuccess { noticeBoard ->
                    setState { copy(noticeBoardItem = noticeBoard.content) }
                }
                    .onFailure { throwable ->
                        DebugLog.e("HomeViewModel", "불러오기 실패: ${throwable.message}")
                        setState { copy(loadState = LoadState.Error) }
                    }
            }
        }

        private fun loadReviewList() {
            viewModelScope.launch {
                val result: Result<ReviewList> = getHomeReviewsUseCase()
                result.onSuccess { review ->
                    setState { copy(reviewList = review.content) }
                }
                    .onFailure { throwable ->
                        DebugLog.e("HomeViewModel", "불러오기 실패: ${throwable.message}")
                        setState { copy(loadState = LoadState.Error) }
                    }
            }
        }

        private fun loadRegion() {
            // Todo : 서버로 부터 지역 받기
        }

        private fun loadUserName() {
            // Todo : 서버로 부터 이름 받기 -> usecase 접근
        }
    }
