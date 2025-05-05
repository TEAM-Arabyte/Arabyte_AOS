package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import com.konkuk.arabyte_aos.presentation.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class NoticeBoardDetailContract {
    data class NoticeBoardDetailUiState(
        val loadState: LoadState = LoadState.Idle,
        val noticeBoardDetail: NoticeBoardDetail =
            NoticeBoardDetail(
                profileImage = "",
                nickname = "나야알바",
                writeDate = "2025/04/21/16:30",
                title = "최악의 알바 후기... 다들 조심하세요!",
                content =
                    "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고 가세요.\n" +
                            "\u2028계약서 작성은 필수고, 근무 조건도 미리 확실히 확인해야 해요. 안 그러면 저처럼 후회할 수도 있어요.\n" +
                            "혹시라도 이상한 점이 있으면 바로 이야기하거나, 빠르게 다른 곳을 알아보는 게 좋아요.\n" +
                            "\n" +
                            "제 경험이 누군가에게 도움이 되길 바라요... \uD83D\uDE22",
                isLiked = false,
                commentList = emptyList(),
            ),
    ) : UiState

    sealed interface NoticeBoardDetailSideEffect : UiSideEffect {
        data object DummySideEffect : NoticeBoardDetailSideEffect
    }

    sealed class NoticeBoardDetailEvent : UiEvent {
        data class GetNoticeBoardDetail(val articleId: Long) : NoticeBoardDetailEvent()
    }
}
