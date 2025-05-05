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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.NoticeBoardDetailComment
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.component.NoticeBoardWriterChip
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
            if (comment.isAnonymous) {
                Image(
                    painter = painterResource(R.drawable.img_profile_default_anonymity),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
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
                text = comment.text,
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
