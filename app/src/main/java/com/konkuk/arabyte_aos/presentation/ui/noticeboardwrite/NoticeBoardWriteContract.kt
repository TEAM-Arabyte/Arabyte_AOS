package com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite

import android.net.Uri
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteNoticeBoardCategoryType
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class NoticeBoardWriteContract {
    data class NoticeBoardWriteUiState(
        val loadState: LoadState = LoadState.Idle,
        val selectCategory: ArabyteNoticeBoardCategoryType? = null,
        val selectIsAnonymous: Boolean = true,
        val titleText: String = "",
        val contentText: String = "",
        val uploadedImageUrls: List<String> = emptyList(),
        val previewImageUri: Uri? = null,
    ) : UiState

    sealed interface NoticeBoardWriteSideEffect : UiSideEffect {
        data object NavigateToBack : NoticeBoardWriteSideEffect

        data object NavigateToNoticeBoardList : NoticeBoardWriteSideEffect

        data object ShowServerErrorToast : NoticeBoardWriteSideEffect

        data object ShowDataValidErrorToast : NoticeBoardWriteSideEffect
    }

    sealed class NoticeBoardWriteEvent : UiEvent {
        data class CategoryClick(val clickedCategory: ArabyteNoticeBoardCategoryType) : NoticeBoardWriteEvent()

        data class AnonymousClick(val clickAnonymous: Boolean) : NoticeBoardWriteEvent()

        data class TitleTextChanged(val title: String) : NoticeBoardWriteEvent()

        data class ContentTextChanged(val content: String) : NoticeBoardWriteEvent()

        data object WriteCompleteButtonClicked : NoticeBoardWriteEvent()

        data class PhotoSelected(val uri: Uri) : NoticeBoardWriteEvent()
    }
}
