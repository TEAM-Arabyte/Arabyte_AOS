package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun ArabyteCheckButton(
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .drawWithContent {
                    drawContent()
                    drawRoundRect(
                        color = arabyteColors.mainBlue,
                        style = Stroke(width = 1.dp.toPx(), pathEffect = PathEffect.dashPathEffect(floatArrayOf(5f, 5f), 0f)),
                        cornerRadius = CornerRadius(9.dp.toPx()),
                    )
                }
                .roundedBackgroundWithPadding(cornerRadius = 9.dp, backgroundColor = ArabyteTheme.colors.white, padding = PaddingValues(vertical = 18.dp))
                .noRippleClickable { buttonClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_plus_20), tint = Color.Unspecified, contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = stringResource(R.string.button_check), color = ArabyteTheme.colors.mainBlue, style = ArabyteTheme.typography.bodySemi13)
    }
}

@Preview
@Composable
private fun ArabyteCheckButtonPreview() {
    ArabyteAOSTheme {
        Column(modifier = Modifier.background(color = ArabyteTheme.colors.white).padding(10.dp)) {
            ArabyteCheckButton()
        }
    }
}
