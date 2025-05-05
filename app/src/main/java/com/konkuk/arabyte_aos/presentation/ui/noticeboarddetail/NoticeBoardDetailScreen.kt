package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import buildCommentTree
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetail
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component.NoticeBoardDetailCommentItem
import com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component.NoticeBoardDetailCommentTextField
import com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component.NoticeBoardDetailContent
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.presentation.util.modifier.advancedImePadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import flattenCommentTree

@Composable
fun NoticeBoardDetailRoute(
    articleId: Long,
    modifier: Modifier = Modifier,
    viewModel: NoticeBoardDetailViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) { viewModel.setEvent(NoticeBoardDetailContract.NoticeBoardDetailEvent.GetNoticeBoardDetail(articleId = articleId)) }
    DebugLog.d("NoticeBoardDetailScreen", "ArticleId : $articleId")
    NoticeBoardDetailScreen(
        noticeBoardDetail = uiState.noticeBoardDetail,
        innerPaddingValues = innerPaddingValues,
        modifier = modifier,
        onTextChange = { viewModel.setEvent(NoticeBoardDetailContract.NoticeBoardDetailEvent.ChangeCommentText(it)) },
        onAnonymousChanged = { viewModel.setEvent(NoticeBoardDetailContract.NoticeBoardDetailEvent.ChangeAnonymous(it)) },
        onSend = { viewModel.setEvent(NoticeBoardDetailContract.NoticeBoardDetailEvent.SubmitComment(articleId)) },
        text = uiState.postComment.text,
        isAnonymous = uiState.postComment.isAnonymous,
    )
}

@Composable
fun NoticeBoardDetailScreen(
    noticeBoardDetail: NoticeBoardDetail,
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    onTextChange: (String) -> Unit,
    onAnonymousChanged: (Boolean) -> Unit,
    onSend: () -> Unit,
    text: String,
    isAnonymous: Boolean,
) {
    val commentTree = remember(noticeBoardDetail.comments) { buildCommentTree(noticeBoardDetail.comments) }
    val flattenList = remember(noticeBoardDetail.comments) { flattenCommentTree(commentTree) }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(ArabyteTheme.colors.white)
                .padding(innerPaddingValues)
                .advancedImePadding(),
    ) {
        ArabyteTopAppBar(
            useBack = true,
            onBackClick = {},
            optionalIconRes = R.drawable.ic_all_optional_button_45,
            onOptionalClick = {},
        )

        LazyColumn(
            modifier =
                Modifier
                    .weight(1f)
                    .fillMaxWidth(),
        ) {
            item {
                NoticeBoardDetailContent(
                    writerProfileImage = "",
                    writerNickname = noticeBoardDetail.nickname,
                    writeDate = noticeBoardDetail.createdAt,
                    title = noticeBoardDetail.title,
                    content = noticeBoardDetail.text,
                    isLiked = noticeBoardDetail.isLiked,
                )
            }
            item {
                HorizontalDivider(thickness = 8.dp, color = ArabyteTheme.colors.gray01)
            }

            item {
                Text(
                    text = "댓글 ${noticeBoardDetail.comments.size}",
                    style = ArabyteTheme.typography.bodySemi13,
                    color = ArabyteTheme.colors.gray06,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                )
                Spacer(modifier = Modifier.height(11.dp))
            }

            if (flattenList.isEmpty()) {
                item {
                    // Todo: 엠티뷰 컴포넌트 부르기
                }
            } else {
                itemsIndexed(
                    items = flattenList,
                ) { index, (comment, isReply) ->
                    val isWriter = comment.nickname == noticeBoardDetail.nickname
                    if (index != 0 && !isReply) {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = ArabyteTheme.colors.gray01,
                        )
                    }
                    NoticeBoardDetailCommentItem(
                        comment = comment,
                        isWriter = isWriter,
                    )
                }
            }
            item {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = ArabyteTheme.colors.gray01,
                )
            }
        }
        NoticeBoardDetailCommentTextField(
            text = text,
            onTextChange = onTextChange,
            isAnonymous = isAnonymous,
            onAnonymousChanged = onAnonymousChanged,
            onSend = onSend,
            modifier =
                Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp),
        )
    }
}

@Preview
@Composable
private fun NoticeBoardDetailScreenPreview() {
    ArabyteAOSTheme {
        // NoticeBoardDetailScreen()
    }
}
