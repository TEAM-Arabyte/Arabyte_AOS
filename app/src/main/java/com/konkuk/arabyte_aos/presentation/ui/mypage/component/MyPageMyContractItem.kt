package com.konkuk.arabyte_aos.presentation.ui.mypage.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
 * 마이페이지 내, 근로 계약서 인증과 관련된 알바를 나타내는 컴포넌트입니다.
 * 이 컴포넌트는 근로지명과 근로 계약서 인증 여부를 표시합니다.
 *
 * @param modifier UI 수정 사항을 추가할 수 있는 Modifier입니다.
 * @param companyName 알바 근로지 이름입니다.
 * @param isCertified 사용자가 근로계약서를 인증한 근로지인 경우 true로 설정합니다. 기본값은 false입니다.
 */

@Composable
fun MyPageMyContractItem(
    companyName: String,
    modifier: Modifier = Modifier,
    isCertified: Boolean = false,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .roundedBackgroundWithPadding(
                    backgroundColor = ArabyteTheme.colors.gray01,
                    cornerRadius = 9.dp,
                    padding = PaddingValues(horizontal = 16.dp, vertical = 17.dp),
                ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        val (textColor, certificationIcon) =
            if (isCertified) {
                Pair(ArabyteTheme.colors.mainBlue, R.drawable.ic_all_auth_check_16)
            } else {
                Pair(ArabyteTheme.colors.gray03, R.drawable.ic_all_check_dots_20)
            }
        Text(
            text = companyName,
            style = ArabyteTheme.typography.bodySemi13,
            color = textColor,
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = certificationIcon),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}
