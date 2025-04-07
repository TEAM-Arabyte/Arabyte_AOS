package com.konkuk.arabyte_aos.presentation.ui.signup.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteSmallButton
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun SignUpAgeGrid(
    modifier: Modifier = Modifier,
    selectedAge: String? = null,
    onClick: (String) -> Unit = {}
) {
    val ageList = listOf(
        "20세 미만", "20대 초반",
        "20대 후반", "30대 초반",
        "30대 후반", "40세 이상")

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Text(text = stringResource(R.string.sign_up_age), style = ArabyteTheme.typography.bodySemi15, color = ArabyteTheme.colors.black)
        Spacer(modifier = Modifier.height(6.dp))
        for (rowIndex in 0 until 3) {
            val left = ageList[rowIndex * 2]
            val right = ageList[rowIndex * 2 + 1]

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                ArabyteSmallButton(
                    modifier = Modifier.weight(1f),
                    buttonText = left,
                    enabled = selectedAge == left,
                    buttonClicked = { onClick(left) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                ArabyteSmallButton(
                    modifier = Modifier.weight(1f),
                    buttonText = right,
                    enabled = selectedAge == right,
                    buttonClicked = { onClick(right) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun SignUpAgeGridPreview() {
    var selectedAge by remember { mutableStateOf<String?>(null) }

    ArabyteAOSTheme {
        SignUpAgeGrid(
            selectedAge = selectedAge,
            onClick = { selected ->
                selectedAge = selected
            }
        )
    }
}