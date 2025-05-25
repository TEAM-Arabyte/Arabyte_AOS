package com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteLargeTextField
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewWriteEvaluation(
    star: Int,
    starClicked: (Int) -> Unit,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    reviewText: String = "",
) {
    Column(
        modifier =
            modifier.fillMaxWidth(),
    ) {
        Text(text = stringResource(R.string.review_write_review_title), style = ArabyteTheme.typography.bodySemi15, color = ArabyteTheme.colors.black)
        Spacer(modifier = Modifier.height(11.dp))
        ReviewWriteStar(
            selectedStar = star,
        ) { starClicked(it) }
        Spacer(modifier = Modifier.height(14.dp))

        ArabyteLargeTextField(
            textMaxLength = 300,
            placeholder = stringResource(R.string.review_write_review_placeholder),
            text = reviewText,
            onValueChange = { text ->
                onTextChanged(text)
            },
        )
    }
}

@Preview
@Composable
private fun ReviewWriteEvaluationPreview() {
    ArabyteAOSTheme { ReviewWriteEvaluation(1, {}, {}) }
}
