package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.model.NoticeBoardDetailComment
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.component.NoticeBoardWriterChip
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun NoticeBoardDetailCommentItem(
    comment: NoticeBoardDetailComment,
    isWriter: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 9.dp),
    ) {
        Row(
            modifier = Modifier,
        ) {
            if (comment.parentId != null) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_notice_board_arrow_comment_18),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
                Spacer(Modifier.width(10.dp))
            }
            if (comment.isAnonymous || comment.profileImage.isBlank()) {
                Image(
                    painter = painterResource(R.drawable.img_profile_default_anonymity),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                )
            } else {
                AsyncImage(
                    model = comment.profileImage,
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.img_profile_default_anonymity),
                    error = painterResource(R.drawable.img_profile_default_anonymity),
                )
            }
        }
        Spacer(Modifier.width(10.dp))
        Column(
            modifier =
                Modifier
                    .wrapContentWidth()
                    .padding(top = 7.dp),
            Arrangement.spacedBy(5.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = comment.nickname,
                    style = ArabyteTheme.typography.bodySemi13,
                    color = ArabyteTheme.colors.black,
                )
                if (isWriter) {
                    Spacer(Modifier.width(4.dp))
                    NoticeBoardWriterChip()
                }
            }
            Text(
                text = comment.content,
                style = ArabyteTheme.typography.bodyMed13,
                color = ArabyteTheme.colors.gray07,
            )
            Row {
                Text(
                    text = stringResource(R.string.notice_board_comment_reply),
                    style = ArabyteTheme.typography.capMed11,
                    color = ArabyteTheme.colors.gray04,
                )
                Spacer(Modifier.width(14.dp))
                Text(
                    text = stringResource(R.string.notice_board_comment_report),
                    style = ArabyteTheme.typography.capMed11,
                    color = ArabyteTheme.colors.gray04,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoticeBoardDetailCommentPrev1() {
    ArabyteAOSTheme {
        NoticeBoardDetailCommentItem(
            comment =
                NoticeBoardDetailComment(
                    profileImage = "",
                    nickname = "휘둥",
                    content = "무슨 알바하셨나요?",
                    isAnonymous = false,
                    commentId = 1,
                    parentId = null,
                ),
            isWriter = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NoticeBoardDetailCommentPrev2() {
    ArabyteAOSTheme {
        NoticeBoardDetailCommentItem(
            comment =
                NoticeBoardDetailComment(
                    profileImage = "d",
                    nickname = "휘둥",
                    content = "고깃집 알바 했어요!",
                    isAnonymous = true,
                    commentId = 1,
                    parentId = 1,
                ),
            isWriter = false,
        )
    }
}
