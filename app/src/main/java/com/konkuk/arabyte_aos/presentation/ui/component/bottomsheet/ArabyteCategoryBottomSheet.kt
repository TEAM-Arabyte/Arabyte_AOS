package com.konkuk.arabyte_aos.presentation.ui.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteChipButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteNormalButton
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteCategoryBottomSheet(
    modifier: Modifier = Modifier,
    bottomSheetClose: () -> Unit = {},
    completeButtonClicked: () -> Unit = {},
    selectedCategories: List<String> = emptyList(),
    categoryChipClicked: (String) -> Unit = {},
) {
    Column(
        modifier =
            modifier
                .background(
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                    color = ArabyteTheme.colors.white,
                )
                .fillMaxWidth()
                .noRippleClickable { }
                .padding(top = 19.dp, start = 16.dp, end = 16.dp),
    ) {
        Text(
            stringResource(R.string.category_bottom_sheet_title),
            style = ArabyteTheme.typography.bodyBold15,
        )
        Spacer(modifier = Modifier.height(21.dp))
        FlowRow(
            mainAxisSpacing = 10.dp,
            crossAxisSpacing = 10.dp,
        ) {
            ArabyteJobCategory.entries.forEach { category ->
                ArabyteChipButton(
                    buttonText = category.label,
                    enabled = selectedCategories.contains(category.label),
                    buttonClicked = {
                        categoryChipClicked(category.label)
                    },
                )
            }
        }
        Spacer(modifier = Modifier.height(28.dp))
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
        ) {
            ArabyteNormalButton(
                buttonText = stringResource(R.string.all_bottom_sheet_close),
                modifier = Modifier.weight(101f),
                enabled = false,
                buttonClicked = bottomSheetClose,
            )
            Spacer(modifier = Modifier.width(12.dp))
            ArabyteNormalButton(
                buttonText = stringResource(R.string.all_bottom_sheet_confirm),
                modifier = Modifier.weight(218f),
                buttonClicked = completeButtonClicked,
            )
        }
    }
}

@Preview
@Composable
private fun ArabyteCategoryBottomSheetPreview() {
    ArabyteAOSTheme {
        ArabyteCategoryBottomSheet()
    }
}
