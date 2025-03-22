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

@Composable
fun MyPageMyContractItem(
    modifier: Modifier = Modifier,
    companyName: String,
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
