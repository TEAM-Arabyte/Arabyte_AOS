package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme.colors

@Composable
fun ArabyteChipButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonClicked: () -> Unit = {},
) {
    Text(
        modifier =
            modifier
                .then(
                    if (enabled) {
                        Modifier.border(
                            width = 1.dp,
                            color = ArabyteTheme.colors.mainBlue,
                            shape = RoundedCornerShape(20.dp),
                        )
                    } else {
                        Modifier
                    },
                )
                .roundedBackgroundWithPadding(
                    backgroundColor = if (enabled) ArabyteTheme.colors.lightBlue else ArabyteTheme.colors.gray01,
                    padding = PaddingValues(vertical = 6.dp, horizontal = 13.dp),
                    cornerRadius = 20.dp,
                )
                .noRippleClickable {
                    buttonClicked()
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
    Column {
        ArabyteChipButton(buttonText = "chip button")
        ArabyteChipButton(buttonText = "chip button", enabled = false)
    }
}
