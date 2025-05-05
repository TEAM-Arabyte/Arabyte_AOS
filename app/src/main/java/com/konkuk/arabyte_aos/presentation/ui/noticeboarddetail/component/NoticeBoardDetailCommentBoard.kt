package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import buildCommentTree
import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetailComment
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import flattenCommentTree

@Composable
fun NoticeBoardDetailCommentBoard(
    commentList: List<NoticeBoardDetailComment>,
    articleWriteNickname: String,
    modifier: Modifier = Modifier,
) {
    val commentTree = remember(commentList) { buildCommentTree(commentList) }
    val flattenList = remember(commentList) { flattenCommentTree(commentTree) }

    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .background(color = ArabyteTheme.colors.white)
                .padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.height(13.dp))
        Text(text = "댓글 ${commentList.size}", style = ArabyteTheme.typography.bodySemi13, color = ArabyteTheme.colors.gray06)
        Spacer(modifier = Modifier.height(11.dp))
        if (commentList.isEmpty()) {
            Text(
                text = "아직 등록된 댓글이 없어요",
                style = ArabyteTheme.typography.bodySemi13,
                color = ArabyteTheme.colors.gray05,
                modifier =
                    Modifier
                        .padding(vertical = 16.dp)
                        .align(Alignment.CenterHorizontally),
            )
        } else {
//            LazyColumn {
//                items(
//
//                ) { (comment, isReply) ->
//                    val isWriter = comment.nickname == articleWriteNickname
//                    NoticeBoardDetailCommentItem(
//                        comment = comment,
//                        isWriter = isWriter,
//                    )
//                }
//            }
        }
    }
}
