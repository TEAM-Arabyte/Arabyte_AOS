package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.type.ArabyteFilteringType
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteFilteringButton(
    arabyteFilteringType: ArabyteFilteringType,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    buttonClicked: (Boolean) -> Unit = {},
) {
    val (borderColor, backgroundColor, textColor) =
        when (enabled) {
            true -> Triple(ArabyteTheme.colors.mainBlue, ArabyteTheme.colors.lightBlue, ArabyteTheme.colors.mainBlue)
            false -> Triple(ArabyteTheme.colors.gray02, ArabyteTheme.colors.white, ArabyteTheme.colors.gray05)
        }

    val iconTint = if (enabled) ArabyteTheme.colors.mainBlue else ArabyteTheme.colors.gray05

    Row(
        modifier =
            modifier
                .border(shape = RoundedCornerShape(30.dp), width = 1.dp, color = borderColor)
                .roundedBackgroundWithPadding(cornerRadius = 30.dp, backgroundColor = backgroundColor, padding = PaddingValues(start = 13.dp, top = 6.dp, end = 11.dp, bottom = 6.dp))
                .noRippleClickable { buttonClicked(!enabled) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        if (arabyteFilteringType == ArabyteFilteringType.CHECK)
            {
                Icon(imageVector = ImageVector.vectorResource(arabyteFilteringType.imageDrawableRes), tint = Color.Unspecified, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = stringResource(arabyteFilteringType.stringRes), color = textColor, style = ArabyteTheme.typography.bodySemi13)
            } else
            {
                Text(text = stringResource(arabyteFilteringType.stringRes), color = textColor, style = ArabyteTheme.typography.bodySemi13)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(imageVector = ImageVector.vectorResource(arabyteFilteringType.imageDrawableRes), tint = iconTint, contentDescription = null)
            }
    }
}

@Preview
@Composable
private fun ArabyteAddPhotoButtonPreview() {
    var isEnabled1 by remember { mutableStateOf(true) }
    var isEnabled2 by remember { mutableStateOf(true) }
    var isEnabled3 by remember { mutableStateOf(true) }

    ArabyteAOSTheme {
        Row {
            ArabyteFilteringButton(arabyteFilteringType = ArabyteFilteringType.CHECK, enabled = isEnabled1, buttonClicked = { isEnabled1 = it })
            ArabyteFilteringButton(arabyteFilteringType = ArabyteFilteringType.REGION, enabled = isEnabled2, buttonClicked = { isEnabled2 = it })
            ArabyteFilteringButton(arabyteFilteringType = ArabyteFilteringType.CATEGORY, enabled = isEnabled3, buttonClicked = { isEnabled3 = it })
        }
    }
}
