package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun NoticeBoardDetailCommentTextField(
    text: String,
    onTextChange: (String) -> Unit,
    isAnonymous: Boolean,
    onAnonymousChanged: (Boolean) -> Unit,
    onSend: () -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions =
        KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Send,
        ),
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val anonymousIcon = if (isAnonymous) R.drawable.ic_all_check_20 else R.drawable.ic_all_check_dots_20

    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .background(
                    color = ArabyteTheme.colors.gray01,
                    shape = RoundedCornerShape(5.dp),
                )
                .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier =
                Modifier
                    .noRippleClickable {
                        onAnonymousChanged(!isAnonymous)
                    }
                    .padding(vertical = 1.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = anonymousIcon),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = Color.Unspecified,
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = stringResource(R.string.notice_board_comment_anonymous),
                color = ArabyteTheme.colors.mainBlue,
                style = ArabyteTheme.typography.capSemi11,
            )
        }
        Spacer(Modifier.width(7.dp))
        BasicTextField(
            value = text,
            onValueChange = onTextChange,
            singleLine = true,
            modifier = Modifier.weight(1f),
            textStyle = ArabyteTheme.typography.bodyMed13.copy(color = ArabyteTheme.colors.black),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = stringResource(id = R.string.notice_board_comment_text_field),
                        color = ArabyteTheme.colors.gray03,
                        style = ArabyteTheme.typography.bodyMed13,
                    )
                }
                innerTextField()
            },
            keyboardOptions = keyboardOptions,
            keyboardActions =
                KeyboardActions(
                    onSend = {
                        onSend()
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    },
                ),
            cursorBrush = if (text.isEmpty()) SolidColor(ArabyteTheme.colors.gray03) else SolidColor(ArabyteTheme.colors.black),
        )
        Spacer(Modifier.width(7.dp))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_all_send_24),
            tint = if (text.isEmpty()) Color.Unspecified else ArabyteTheme.colors.mainBlue,
            contentDescription = null,
            modifier = Modifier.noRippleClickable { onSend() },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NoticeBoardDetailCommentTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    var isAnonymous by remember { mutableStateOf(false) }

    ArabyteAOSTheme {
        NoticeBoardDetailCommentTextField(
            text = text,
            onTextChange = { text = it },
            isAnonymous = isAnonymous,
            onAnonymousChanged = { isAnonymous = it },
            onSend = {
                DebugLog.d("z", "댓글 전송: $text, 익명: $isAnonymous")
                text = ""
            },
        )
    }
}
