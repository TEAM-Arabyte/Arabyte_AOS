package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.conditionalBorder
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteEvaluationButton(
    likeCount: Int,
    iconRes: Int,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    buttonClicked: (Boolean) -> Unit = {},
) {
    val (backgroundColor, textColor) =
        when (enabled) {
            true -> Pair(ArabyteTheme.colors.gray07, ArabyteTheme.colors.white)
            false -> Pair(ArabyteTheme.colors.white, ArabyteTheme.colors.black)
        }

    Row(
        modifier =
        modifier
            .conditionalBorder(
                enabled = !enabled,
                color = ArabyteTheme.colors.gray01,
                width = 1.dp,
                shape = RoundedCornerShape(50.dp)
            )
            .roundedBackgroundWithPadding(cornerRadius = 30.dp, backgroundColor = backgroundColor, padding = PaddingValues(vertical = 5.dp, horizontal = 11.dp))
            .noRippleClickable { buttonClicked(!enabled) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(imageVector = ImageVector.vectorResource(iconRes), tint = Color.Unspecified, contentDescription = null)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = likeCount.toString(), color = textColor, style = ArabyteTheme.typography.bodySemi13)
    }
}

@Preview
@Composable
private fun ArabyteEvaluationButtonPreview() {
    var isEnabled by remember { mutableStateOf(true) }
    ArabyteAOSTheme {
        Column {
            ArabyteEvaluationButton(likeCount = 1, iconRes = R.drawable.ic_review_emotion_normal_20, enabled = isEnabled, buttonClicked = { isEnabled = it })
        }
    }
}
