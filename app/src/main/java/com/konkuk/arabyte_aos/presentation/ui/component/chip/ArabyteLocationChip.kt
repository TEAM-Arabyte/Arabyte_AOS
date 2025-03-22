package com.konkuk.arabyte_aos.presentation.ui.component.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

/**
 * 알바 점포의 위치를 나타내는 칩 컴포넌트입니다.
 * 이 컴포넌트는 리뷰 리스트에서 일반적으로 사용되지만, 공통적으로도 활용될 수 있습니다.
 *
 * @param modifier UI 수정 사항을 추가할 수 있는 Modifier입니다.
 * @param locationText 표시할 위치 정보를 담고 있는 문자열입니다.
 */
@Composable
fun ArabyteLocationChip(
    modifier: Modifier = Modifier,
    locationText: String,
) {
    Row(
        modifier =
        Modifier
            .then(modifier)
            .roundedBackgroundWithPadding(
                backgroundColor = ArabyteTheme.colors.gray01,
                cornerRadius = 3.dp,
                padding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterHorizontally)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_all_location_13),
            contentDescription = null,
            tint = Color.Unspecified,
        )
        Text(
            text = locationText,
            style = ArabyteTheme.typography.capSemi9,
            color = ArabyteTheme.colors.gray07,
        )
    }
}
