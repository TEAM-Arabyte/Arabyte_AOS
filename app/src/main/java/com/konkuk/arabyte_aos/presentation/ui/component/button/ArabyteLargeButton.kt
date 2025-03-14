package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun ArabyteLargeButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    clickable: Boolean = true,
    buttonClicked: () -> Unit = {},
) {
    Text(
        modifier =
            modifier
                .fillMaxWidth()
                .roundedBackgroundWithPadding(
                    backgroundColor = if (clickable) arabyteColors.mainBlue else arabyteColors.gray01,
                    padding = PaddingValues(vertical = 19.5.dp),
                )
                .noRippleClickable {
                    buttonClicked()
                },
        text = buttonText,
        color = if (clickable) arabyteColors.white else arabyteColors.gray05,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
private fun ArabyteLargeButtonPreview() {
    Column {
        ArabyteLargeButton(buttonText = "Button")
        ArabyteLargeButton(buttonText = "Button", clickable = false)
    }
}
