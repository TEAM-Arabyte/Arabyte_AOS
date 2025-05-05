package com.konkuk.arabyte_aos.presentation.ui.component.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteNormalButton
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteTwoButtonDialog(
    title: String,
    completeButtonText: String,
    cancelButtonClicked: () -> Unit,
    completeButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    cancelButtonText: String = stringResource(R.string.all_cancel_button),
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
        ArabyteTwoButtonDialog(
            title = "삭제하기",
            completeButtonText = "삭제",
            cancelButtonClicked = {},
            completeButtonClicked = {},
            cancelButtonText = "취소",
        )
    }
}
