package com.konkuk.arabyte_aos.presentation.ui.mypage.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun MyPageAddContractButton(
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
) {
    Row(
        modifier =
        modifier
            .fillMaxWidth()
            .border(shape = RoundedCornerShape(7.dp), width = 1.dp, color = ArabyteTheme.colors.mainBlue)
            .roundedBackgroundWithPadding(cornerRadius = 7.dp, backgroundColor = ArabyteTheme.colors.lightBlue, padding = PaddingValues(vertical = 18.dp))
            .noRippleClickable { buttonClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_camera_18), tint = ArabyteTheme.colors.mainBlue, contentDescription = null)
        Spacer(modifier = Modifier.width(9.dp))
        Text(text = "사진으로 인증하기", color = ArabyteTheme.colors.mainBlue, style = ArabyteTheme.typography.bodySemi13)
    }
}

@Preview
@Composable
private fun MyPageAddContractButtonPreview() {
    ArabyteAOSTheme {
        MyPageAddContractButton()
    }
}
