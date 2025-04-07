package com.konkuk.arabyte_aos.presentation.ui.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.type.ArabyteCareerTextFieldType
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteCareerTextField(
    placeholder: String,
    modifier: Modifier = Modifier,
    text: String = "",
    careerTextFieldType: ArabyteCareerTextFieldType = ArabyteCareerTextFieldType.YEAR,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = { _ -> },
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Default),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    Row {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier =
                    modifier
                        .width(96.dp)
                        .roundedBackgroundWithPadding(
                            backgroundColor = ArabyteTheme.colors.gray01,
                            cornerRadius = 9.dp,
                        )
                        .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BasicTextField(
                    modifier =
                        Modifier
                            .weight(1f)
                            .padding(vertical = 15.dp),
                    value = text,
                    onValueChange = { newValue ->
                        if (newValue.isEmpty()) {
                            onValueChange(newValue)
                        } else if (
                            newValue.all { it.isDigit() } &&
                            newValue.toIntOrNull() in careerTextFieldType.valueRange
                        ) {
                            onValueChange(newValue)
                        }
                    },
                    cursorBrush = SolidColor(ArabyteTheme.colors.black),
                    singleLine = true,
                    keyboardActions = keyboardActions,
                    keyboardOptions =
                        keyboardOptions.copy(
                            keyboardType = KeyboardType.Number,
                        ),
                    visualTransformation = visualTransformation,
                    textStyle = ArabyteTheme.typography.bodySemi15.copy(color = ArabyteTheme.colors.black),
                    decorationBox = { innerTextField ->
                        innerTextField()
                        if (text.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = ArabyteTheme.colors.gray03,
                                style = ArabyteTheme.typography.bodySemi15,
                            )
                        }
                    },
                )
            }
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = stringResource(careerTextFieldType.stringRes),
                color = ArabyteTheme.colors.black,
                style = ArabyteTheme.typography.bodyBold17,
            )
        }
    }
}

@Preview
@Composable
private fun ArabyteCareerTextFieldPreview() {
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    ArabyteAOSTheme {
        Row(modifier = Modifier.background(color = ArabyteTheme.colors.white)) {
            ArabyteCareerTextField(
                placeholder = "0",
                text = year,
                onValueChange = { newText ->
                    year = newText
                },
            )
            Spacer(modifier = Modifier.width(17.dp))
            ArabyteCareerTextField(
                placeholder = "0",
                text = month,
                careerTextFieldType = ArabyteCareerTextFieldType.MONTH,
                onValueChange = { newText ->
                    month = newText
                },
            )
        }
    }
}
