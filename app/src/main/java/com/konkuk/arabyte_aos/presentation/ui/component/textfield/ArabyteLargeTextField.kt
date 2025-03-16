package com.konkuk.arabyte_aos.presentation.ui.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteLargeTextField(
    textMaxLength: Int,
    placeholder: String,
    modifier: Modifier = Modifier,
    text: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = { _ -> },
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Default),
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {

    Column {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = modifier
                    .weight(1f)
                    .height(215.dp)
                    .roundedBackgroundWithPadding(
                        backgroundColor = ArabyteTheme.colors.gray01,
                        cornerRadius = 9.dp
                    )
                    .padding(horizontal = 11.dp, vertical = 13.dp),
            ) {
                BasicTextField(
                    modifier = Modifier
                        .weight(1f),
                    value = text,
                    onValueChange = {
                        if (it.codePointCount(0, it.length) <= textMaxLength) {
                            onValueChange(it)
                        }
                    },
                    cursorBrush = SolidColor(ArabyteTheme.colors.black),
                    keyboardActions = keyboardActions,
                    keyboardOptions = keyboardOptions,
                    visualTransformation = visualTransformation,
                    textStyle = ArabyteTheme.typography.bodySemi13.copy(color = ArabyteTheme.colors.black),
                    decorationBox = { innerTextField ->
                        innerTextField()
                        if (text.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = ArabyteTheme.colors.gray03,
                                style = ArabyteTheme.typography.bodyMed13
                            )
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${text.length}/$textMaxLength",
                color = ArabyteTheme.colors.gray06,
                style = ArabyteTheme.typography.capSemi11
            )
        }
    }

}

@Preview
@Composable
private fun ArabyteLargeTextFieldPreview() {
    var value by remember { mutableStateOf("") }
    ArabyteAOSTheme {
        Column(modifier = Modifier.background(color = ArabyteTheme.colors.white)) {
            ArabyteLargeTextField(
                textMaxLength = 300,
                placeholder = "placeholder",
                text = value,
                onValueChange = { newText ->
                    value = newText
                }
            )
        }
    }
}