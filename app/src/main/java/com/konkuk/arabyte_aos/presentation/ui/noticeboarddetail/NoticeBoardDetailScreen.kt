package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component.NoticeBoardDetailCommentBoard
import com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component.NoticeBoardDetailContent
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun NoticeBoardDetailRoute(
    articleId: Long,
    modifier: Modifier = Modifier,
    viewModel: NoticeBoardDetailViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    LaunchedEffect(Unit) { viewModel.setEvent(NoticeBoardDetailContract.NoticeBoardDetailEvent.GetNoticeBoardDetail(articleId = articleId)) }
    DebugLog.d("NoticeBoardDetailScreen", "ArticleId : $articleId")
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    NoticeBoardDetailScreen(noticeBoardDetail = uiState.noticeBoardDetail, innerPaddingValues = innerPaddingValues, modifier = modifier)
}

@Composable
fun NoticeBoardDetailScreen(
    noticeBoardDetail: NoticeBoardDetail,
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(ArabyteTheme.colors.white)
                .padding(innerPaddingValues),
    ) {
        ArabyteTopAppBar(
            useBack = true,
            onBackClick = {},
            optionalIconRes = R.drawable.ic_all_optional_button_45,
            onOptionalClick = {},
        )
        LazyColumn {
            item {
                NoticeBoardDetailContent(
                    writerProfileImage = noticeBoardDetail.profileImage,
                    writerNickname = noticeBoardDetail.nickname,
                    writeDate = noticeBoardDetail.writeDate,
                    title = noticeBoardDetail.title,
                    content = noticeBoardDetail.content,
                    isLiked = noticeBoardDetail.isLiked,
                )
            }
            item {
                HorizontalDivider(thickness = 8.dp, color = ArabyteTheme.colors.gray01)
            }
            item {
                NoticeBoardDetailCommentBoard(
                    commentList = noticeBoardDetail.commentList,
                    articleWriteNickname = noticeBoardDetail.nickname,
                )
            }
        }
    }
}

@Preview
@Composable
private fun NoticeBoardDetailScreenPreview() {
    ArabyteAOSTheme {
        // NoticeBoardDetailScreen()
    }
}
