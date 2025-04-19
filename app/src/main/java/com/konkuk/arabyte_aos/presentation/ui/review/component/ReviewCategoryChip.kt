package com.konkuk.arabyte_aos.presentation.ui.review.component

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
 * 리뷰의 카테고리를 나타내는 칩 컴포넌트입니다.
 * 이 컴포넌트는 사용자가 작성한 리뷰를 카테고리별로 구분하여 표시합니다.
 *
 * @param modifier UI 수정 사항을 추가할 수 있는 Modifier입니다.
 * @param categoryResId 리뷰 카테고리 이름을 나타내는 문자열 리소스 ID 입니다.
 */

@Composable
fun ReviewCategoryChip(
    modifier: Modifier = Modifier,
    category: String,
) {
    Row(
        modifier =
            modifier
                .roundedBackgroundWithPadding(
                    backgroundColor = ArabyteTheme.colors.subBlue,
                    cornerRadius = 3.dp,
                    padding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = category.toString(),
            style = ArabyteTheme.typography.capSemi9,
            color = ArabyteTheme.colors.white,
        )
    }
}
