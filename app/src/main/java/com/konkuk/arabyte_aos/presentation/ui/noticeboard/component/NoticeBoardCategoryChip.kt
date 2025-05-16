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
 * 게시판의 카테고리를 나타내는 칩 컴포넌트입니다.
 * 이 컴포넌트는 게시판의 종류를 표시하여 사용자에게 게시글의 분류 정보를 제공합니다.
 *
 * @param modifier UI 수정 사항을 추가할 수 있는 Modifier입니다.
 * @param categoryResId 게시판 카테고리 이름을 나타내는 문자열 리소스 ID 입니다. ex) 자유게시판, 정보게시판
 */

@Composable
fun NoticeBoardCategoryChip(
    category: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .roundedBackgroundWithPadding(
                    backgroundColor = ArabyteTheme.colors.gray01,
                    cornerRadius = 3.dp,
                    padding = PaddingValues(horizontal = 7.dp, vertical = 3.dp),
                ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = category,
            style = ArabyteTheme.typography.capMed9,
            color = ArabyteTheme.colors.gray05,
        )
    }
}
