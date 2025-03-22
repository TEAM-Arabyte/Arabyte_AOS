package com.konkuk.arabyte_aos.presentation.ui.onboarding.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

/**
 * 온보딩 화면 상단에 현재 진행 상황을 나타내는 컴포넌트입니다.
 * @param modifier UI 수정 사항을 추가할 수 있는 Modifier입니다.
 * @param number 현재 진행 상황을 나타내는 숫자입니다.
 * @param isCompleted 진행 상황의 완료 여부를 나타내는 Boolean 값입니다.
 *                   true일 경우 완료된 상태를 의미합니다.
 */

@Composable
fun OnboardingNumberChip(
    modifier: Modifier = Modifier,
    number: Int,
    isCompleted: Boolean,
) {
    val (borderColor, backgroundColor, textColor) =
        if (isCompleted) {
            Triple(
                ArabyteTheme.colors.mainBlue,
                ArabyteTheme.colors.lightBlue,
                ArabyteTheme.colors.mainBlue,
            )
        } else {
            Triple(ArabyteTheme.colors.gray03, ArabyteTheme.colors.gray01, ArabyteTheme.colors.gray03)
        }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        if (number > 1) {
            HorizontalDivider(
                modifier = Modifier.width(22.dp),
                thickness = 2.dp,
                color = borderColor,
            )
        }

        Box(
            modifier =
                modifier
                    .size(32.dp)
                    .border(shape = RoundedCornerShape(50.dp), width = 2.dp, color = borderColor)
                    .roundedBackgroundWithPadding(
                        cornerRadius = 50.dp,
                        backgroundColor = backgroundColor,
                    ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = number.toString(),
                color = textColor,
                style = ArabyteTheme.typography.titleBold18,
            )
        }
    }
}
