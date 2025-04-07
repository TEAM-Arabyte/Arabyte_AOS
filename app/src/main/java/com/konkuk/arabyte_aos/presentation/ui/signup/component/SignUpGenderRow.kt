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
import com.konkuk.arabyte_aos.presentation.util.SignUp.FEMALE
import com.konkuk.arabyte_aos.presentation.util.SignUp.MALE
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun SignUpGenderRow(
    modifier: Modifier = Modifier,
    selectedGender: String? = null,
    onClick: (String) -> Unit = {}
) {
    val gender  = Pair(MALE, FEMALE)
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Text(text = stringResource(R.string.sign_up_gender), style = ArabyteTheme.typography.bodySemi15, color = ArabyteTheme.colors.black)
        Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                ArabyteSmallButton(
                    modifier = Modifier.weight(1f),
                    buttonText = gender.first,
                    enabled = selectedGender == gender.first,
                    buttonClicked = { onClick(gender.first) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                ArabyteSmallButton(
                    modifier = Modifier.weight(1f),
                    buttonText = gender.second,
                    enabled = selectedGender == gender.second,
                    buttonClicked = { onClick(gender.second) }
                )
            }

    }
}

@Preview
@Composable
private fun SignUpGenderRowPreview() {
    var selectedGender by remember { mutableStateOf<String?>(null) }
    ArabyteAOSTheme {
        SignUpGenderRow(
            selectedGender = selectedGender,
            onClick = {gender ->
                selectedGender = gender
            }
        )
    }
}