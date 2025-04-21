package com.konkuk.arabyte_aos.presentation.ui.home

import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor() : BaseViewModel<HomeContract.HomeUiState, HomeContract.HomeSideEffect, HomeContract.HomeEvent>() {
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
            // Todo : 서버로 부터 리스트 받아서, size 3으로
        }

        private fun loadRegion() {
            // Todo : 서버로 부터 지역 받기
        }

        private fun loadReviewList() {
            // Todo : 서버로 부터 리스트 받아서, size 3으로
        }

        private fun loadUserName() {
            // Todo : 서버로 부터 이름 받기 -> usecase 접근
        }
    }
