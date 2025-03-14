package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteEvaluationButton(
    likeCount: Int,
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
    enabled: Boolean = true,
) {
    val (backgroundColor, textColor) =
        when (enabled) {
            true -> Pair(ArabyteTheme.colors.gray07, ArabyteTheme.colors.white)
            false -> Pair(ArabyteTheme.colors.white, ArabyteTheme.colors.black)
        }

    Row(
        modifier =
            modifier
                .then(
                    if (!enabled) {
                        Modifier.border(width = 1.dp, color = ArabyteTheme.colors.gray01, shape = RoundedCornerShape(50.dp))
                    } else {
                        Modifier
                    },
                )
                .roundedBackgroundWithPadding(cornerRadius = 30.dp, backgroundColor = backgroundColor, padding = PaddingValues(vertical = 5.dp, horizontal = 11.dp))
                .noRippleClickable { buttonClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_review_emotion_good_20), tint = Color.Unspecified, contentDescription = null)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = likeCount.toString(), color = textColor, style = ArabyteTheme.typography.bodyMed13)
    }
}

@Preview
@Composable
private fun ArabyteEvaluationButtonPreview() {
    ArabyteAOSTheme {
        Column {
            ArabyteEvaluationButton(likeCount = 1)
            ArabyteEvaluationButton(likeCount = 1, enabled = false)
        }
    }
}
