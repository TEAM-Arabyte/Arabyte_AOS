package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.usecase.locations.GetDongUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetGuUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetSidoUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeBoardDetailViewModel
    @Inject
    constructor(
        private val getSidoUseCase: GetSidoUseCase,
        private val getGuUseCase: GetGuUseCase,
        private val getDongUseCase: GetDongUseCase,
    ) : BaseViewModel<NoticeBoardDetailContract.NoticeBoardDetailUiState, NoticeBoardDetailContract.NoticeBoardDetailSideEffect, NoticeBoardDetailContract.NoticeBoardDetailEvent>() {
        override fun createInitialState(): NoticeBoardDetailContract.NoticeBoardDetailUiState = NoticeBoardDetailContract.NoticeBoardDetailUiState()

        override suspend fun handleEvent(event: NoticeBoardDetailContract.NoticeBoardDetailEvent) {
            when (event) {
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.LoadNoticeBoardDetail -> loadNoticeBoardDetail()

            }
        }

    private fun loadNoticeBoardDetail(){

    }

    }
