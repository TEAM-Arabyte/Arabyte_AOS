package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteChipButton(
    buttonText: String,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    buttonClicked: (Boolean) -> Unit,
) {
    val borderColor = ArabyteTheme.colors.mainBlue

    val borderModifier = remember(enabled) {
        if (enabled) {
            modifier.border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(20.dp),
            )
        } else {
            modifier
        }
    }

    Text(
        modifier = borderModifier
            .roundedBackgroundWithPadding(
                backgroundColor = if (enabled) ArabyteTheme.colors.lightBlue else ArabyteTheme.colors.gray01,
                padding = PaddingValues(vertical = 6.dp, horizontal = 13.dp),
                cornerRadius = 20.dp,
            )
            .noRippleClickable {
                buttonClicked(!enabled)
            },
        text = buttonText,
        color = if (enabled) ArabyteTheme.colors.mainBlue else ArabyteTheme.colors.gray05,
        textAlign = TextAlign.Center,
        style = ArabyteTheme.typography.bodySemi13,
    )
}

@Preview
@Composable
private fun ArabyteChipButtonPreview() {
    var isEnabled by remember { mutableStateOf(true) }
    ArabyteAOSTheme {
        Column {
            ArabyteChipButton(
                buttonText = "chip button",
                enabled = isEnabled,
                buttonClicked = { isEnabled = it },
            )
        }
    }
}
