package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteLikeButton(
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
    enabled : Boolean = true
) {
    val (borderColor, iconTint, textColor) = when (enabled) {
        true -> Triple(ArabyteTheme.colors.gray07, ArabyteTheme.colors.gray07, ArabyteTheme.colors.gray07)
        false -> Triple(ArabyteTheme.colors.gray01, ArabyteTheme.colors.gray03, ArabyteTheme.colors.gray04)
    }

    Row(
        modifier =
        modifier
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(30.dp))
            .roundedBackgroundWithPadding(cornerRadius = 30.dp, backgroundColor = ArabyteTheme.colors.gray01, padding = PaddingValues(vertical = 5.dp, horizontal = 11.dp))
            .noRippleClickable { buttonClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_like_15), tint = iconTint, contentDescription = null)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = stringResource(R.string.button_like), color = textColor , style = ArabyteTheme.typography.bodyMed13)
    }
}

@Preview
@Composable
private fun ArabyteLikeButtonPreview() {
    ArabyteAOSTheme {
        Column {
            ArabyteLikeButton()
            ArabyteLikeButton(enabled = false)
        }
    }
}
