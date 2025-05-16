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
import com.konkuk.arabyte_aos.presentation.util.view.TextFieldValidationState
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import okhttp3.internal.immutableListOf

@Composable
fun ArabyteNormalTextField(
    textMaxLength: Int,
    placeholder: String,
    modifier: Modifier = Modifier,
    errorMessageList: List<String> = immutableListOf("", "error message", "success message"),
    title: String = "",
    text: String = "",
    validationState: TextFieldValidationState = TextFieldValidationState.IDLE,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = { _ -> },
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Default),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    val (errorMessage, errorMessageColor) =
        when (validationState) {
            TextFieldValidationState.IDLE -> Pair(errorMessageList[0], ArabyteTheme.colors.black)
            TextFieldValidationState.INVALID -> Pair(errorMessageList[1], ArabyteTheme.colors.alertRed)
            TextFieldValidationState.VALID -> Pair(errorMessageList[2], ArabyteTheme.colors.mainBlue)
        }

    Column(modifier = modifier.fillMaxWidth()) {
        if (title.isNotEmpty()) {
            Text(text = title, style = ArabyteTheme.typography.bodySemi15, color = ArabyteTheme.colors.black)
            Spacer(modifier = Modifier.height(4.dp))
        }
        Row(
            modifier =
                Modifier
                    .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier =
                    Modifier
                        .weight(1f)
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
                    onValueChange = {
                        if (it.codePointCount(0, it.length) <= textMaxLength) {
                            onValueChange(it)
                        }
                    },
                    cursorBrush = SolidColor(ArabyteTheme.colors.black),
                    singleLine = true,
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
                                style = ArabyteTheme.typography.bodyMed13,
                            )
                        }
                    },
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Text(
                text = errorMessage,
                color = errorMessageColor,
                style = ArabyteTheme.typography.capMed11,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${text.length}/$textMaxLength",
                color = ArabyteTheme.colors.gray06,
                style = ArabyteTheme.typography.capSemi11,
            )
        }
    }
}

@Preview
@Composable
private fun ArabyteNormalTextFieldPreview() {
    var value by remember { mutableStateOf("") }
    ArabyteAOSTheme {
        Column(modifier = Modifier.background(color = ArabyteTheme.colors.white)) {
            ArabyteNormalTextField(
                title = "title",
                textMaxLength = 10,
                placeholder = "placeholder",
                text = value,
                onValueChange = { newText ->
                    value = newText
                },
                validationState =
                    when (value) {
                        "" -> TextFieldValidationState.IDLE
                        "validText" -> TextFieldValidationState.VALID
                        else -> TextFieldValidationState.INVALID
                    },
            )
        }
    }
}
