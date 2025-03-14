package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme.colors

@Composable
fun ArabyteSelectSmallButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonClicked: () -> Unit = {},
) {
    Text(
        modifier =
            modifier
                .roundedBackgroundWithPadding(
                    backgroundColor = if (enabled) ArabyteTheme.colors.lightBlue else ArabyteTheme.colors.gray01,
                    padding = PaddingValues(vertical = 5.dp, horizontal = 8.dp),
                    cornerRadius = 3.dp,
                )
                .noRippleClickable {
                    buttonClicked()
                },
        text = buttonText,
        color = if (enabled) ArabyteTheme.colors.mainBlue else ArabyteTheme.colors.gray06,
        textAlign = TextAlign.Center,
        style = ArabyteTheme.typography.capSemi11,
    )
}

@Preview
@Composable
private fun ArabyteSelectSmallButtonPreview() {
    ArabyteAOSTheme {
        Column {
            ArabyteSelectSmallButton(buttonText = "text")
            ArabyteSelectSmallButton(buttonText = "text", enabled = false)
        }
    }
}
