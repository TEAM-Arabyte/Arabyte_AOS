package com.konkuk.arabyte_aos.presentation.ui.component.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteNormalButton
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteReportReasonDialog(
    title: String,
    completeButtonText: String,
    reasonText: String,
    placeholder: String,
    cancelButtonClicked: () -> Unit,
    completeButtonClicked: () -> Unit,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    cancelButtonText: String = stringResource(R.string.all_cancel_button),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Default),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .roundedBackgroundWithPadding(cornerRadius = 20.dp, backgroundColor = ArabyteTheme.colors.white, padding = PaddingValues(horizontal = 24.dp, vertical = 30.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = title, style = ArabyteTheme.typography.bodyBold17, color = ArabyteTheme.colors.black)
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier =
                Modifier.fillMaxWidth()
                    .roundedBackgroundWithPadding(
                        backgroundColor = ArabyteTheme.colors.gray01,
                        cornerRadius = 9.dp,
                        padding = PaddingValues(horizontal = 16.dp),
                    ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BasicTextField(
                modifier =
                    Modifier
                        .weight(1f)
                        .padding(vertical = 15.dp),
                value = reasonText,
                onValueChange = { newValue ->
                    onValueChange(newValue)
                },
                cursorBrush = SolidColor(ArabyteTheme.colors.black),
                singleLine = true,
                keyboardActions = keyboardActions,
                keyboardOptions = keyboardOptions,
                visualTransformation = visualTransformation,
                textStyle = ArabyteTheme.typography.bodySemi15.copy(color = ArabyteTheme.colors.black),
                decorationBox = { innerTextField ->
                    innerTextField()
                    if (reasonText.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = ArabyteTheme.colors.gray03,
                            style = ArabyteTheme.typography.bodySemi15,
                        )
                    }
                },
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            ArabyteNormalButton(
                buttonText = cancelButtonText,
                enabled = false,
                modifier = Modifier.weight(1f),
                buttonClicked = cancelButtonClicked,
            )
            Spacer(modifier = Modifier.width(8.dp))
            ArabyteNormalButton(
                buttonText = completeButtonText,
                enabled = true,
                modifier = Modifier.weight(1f),
                buttonClicked = completeButtonClicked,
            )
        }
    }
}

@Preview
@Composable
private fun ArabyteTwoButtonDialogPreview() {
    ArabyteAOSTheme {
        ArabyteReportReasonDialog(
            title = "신고 사유를 작성해주세요",
            completeButtonText = "신고",
            cancelButtonClicked = {},
            completeButtonClicked = {},
            cancelButtonText = "취소",
            reasonText = "",
            placeholder = "신고 사유를 입력해주세요",
            onValueChange = {},
        )
    }
}
