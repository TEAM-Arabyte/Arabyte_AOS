package com.konkuk.arabyte_aos.presentation.ui.noticeboard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

/**
 * 게시판 댓글의 작성자를 나타내는 칩 컴포넌트입니다.
 * 이 컴포넌트는 작성자의 댓글에 사용되며, 작성자의 정보를 표시합니다.
 *
 * @param modifier UI 수정 사항을 추가할 수 있는 Modifier입니다.
 * @param writerText 댓글 작성자의 이름을 나타내는 문자열입니다. 기본값은 작성자 입니다.
 */

@Composable
fun NoticeBoardWriterChip(
    modifier: Modifier = Modifier,
    writerText: String = "작성자",
) {
    Row(
        modifier =
            modifier
                .roundedBackgroundWithPadding(
                    backgroundColor = ArabyteTheme.colors.lightBlue,
                    cornerRadius = 2.dp,
                    padding = PaddingValues(horizontal = 5.dp, vertical = 2.dp),
                ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = writerText,
            style = ArabyteTheme.typography.capSemi9,
            color = ArabyteTheme.colors.mainBlue,
        )
    }
}
