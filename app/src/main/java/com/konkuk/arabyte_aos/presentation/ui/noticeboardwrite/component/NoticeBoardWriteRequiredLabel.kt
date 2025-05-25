package com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite.component

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun NoticeBoardWriteRequiredLabel(
    @StringRes labelRedId: Int,
    modifier: Modifier = Modifier,
) {
    val label = stringResource(labelRedId)

    Text(
        text =
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = ArabyteTheme.colors.black),
                ) {
                    append(label)
                }
                withStyle(
                    style = SpanStyle(color = ArabyteTheme.colors.mainBlue),
                ) {
                    append("*")
                }
            },
        modifier = modifier,
        style = ArabyteTheme.typography.bodySemi15,
    )
}

@Preview(showBackground = true)
@Composable
private fun RequiredLabelPrev() {
    ArabyteAOSTheme {
        NoticeBoardWriteRequiredLabel(
            labelRedId = R.string.notice_board_write_is_anonymous,
        )
    }
}
