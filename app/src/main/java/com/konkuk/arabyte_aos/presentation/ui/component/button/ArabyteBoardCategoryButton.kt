package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.type.ArabyteBoardCategoryType
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteBoardCategoryButton(
    arabyteBoardCategoryType: ArabyteBoardCategoryType,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    buttonClicked: (Boolean) -> Unit
) {
    Row(
        modifier =
        modifier
            .then(
                if (!enabled) {
                    Modifier.border(
                        width = 1.dp,
                        color = ArabyteTheme.colors.gray01,
                        shape = RoundedCornerShape(30.dp),
                    )
                } else {
                    Modifier
                },
            )
            .roundedBackgroundWithPadding(
                padding = PaddingValues(vertical = 6.dp, horizontal = 13.dp),
                cornerRadius = 30.dp,
                backgroundColor = if (enabled) ArabyteTheme.colors.gray07 else ArabyteTheme.colors.white
            )
            .noRippleClickable { buttonClicked(!enabled) },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(arabyteBoardCategoryType.imageDrawableRes),
            tint = if (enabled) ArabyteTheme.colors.white else ArabyteTheme.colors.gray07,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = stringResource(arabyteBoardCategoryType.stringRes),
            color = if (enabled) ArabyteTheme.colors.white else ArabyteTheme.colors.gray06,
            style = ArabyteTheme.typography.bodySemi13,
        )
    }
}

@Preview
@Composable
private fun ArabyteSelectSmallButtonPreview() {
    var isEnabled1 by remember { mutableStateOf(true) }
    var isEnabled2 by remember { mutableStateOf(true) }
    ArabyteAOSTheme {
        Column {
            ArabyteBoardCategoryButton(
                arabyteBoardCategoryType = ArabyteBoardCategoryType.FREE,
                enabled = isEnabled1,
                buttonClicked = { isEnabled1 = it }
            )

            ArabyteBoardCategoryButton(
                arabyteBoardCategoryType = ArabyteBoardCategoryType.INFO,
                enabled = isEnabled2,
                buttonClicked = { isEnabled2 = it }
            )
        }
    }
}