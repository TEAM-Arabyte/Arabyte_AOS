package com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.domain.model.Overtime
import com.konkuk.arabyte_aos.domain.model.ReviewRating
import com.konkuk.arabyte_aos.domain.model.ReviewRatingItemWrapper
import com.konkuk.arabyte_aos.domain.model.Salary
import com.konkuk.arabyte_aos.domain.model.SalaryDate
import com.konkuk.arabyte_aos.domain.model.WorkAtmosphere
import com.konkuk.arabyte_aos.domain.model.WorkDifficulty
import com.konkuk.arabyte_aos.domain.model.WorkIntensity
import com.konkuk.arabyte_aos.domain.model.toReviewItem
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteSelectSmallButton
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun <T : Enum<T>> ReviewRatingSection(
    selected: T,
    items: List<ReviewRatingItemWrapper<T>>,
    onSelect: (T) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = items.firstOrNull()?.ask.orEmpty(),
            style = ArabyteTheme.typography.bodySemi13,
            color = ArabyteTheme.colors.gray07,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items.forEach { item ->
                ArabyteSelectSmallButton(
                    buttonText = item.label,
                    enabled = item.value == selected,
                    buttonClicked = { onSelect(item.value) },
                )
            }
        }
    }
}

@Composable
fun ReviewWritingRating(
    modifier: Modifier = Modifier,
    reviewRating: ReviewRating,
    onRatingChanged: (ReviewRating) -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ReviewRatingSection(
            selected = reviewRating.workIntensity,
            items = WorkIntensity.entries.map { it.toReviewItem() },
            onSelect = { selected ->
                onRatingChanged(reviewRating.copy(workIntensity = selected))
            },
        )
        ReviewRatingSection(
            selected = reviewRating.workAtmosphere,
            items = WorkAtmosphere.entries.map { it.toReviewItem() },
            onSelect = { selected ->
                onRatingChanged(reviewRating.copy(workAtmosphere = selected))
            },
        )
        ReviewRatingSection(
            selected = reviewRating.salary,
            items = Salary.entries.map { it.toReviewItem() },
            onSelect = { selected ->
                onRatingChanged(reviewRating.copy(salary = selected))
            },
        )
        ReviewRatingSection(
            selected = reviewRating.salaryDate,
            items = SalaryDate.entries.map { it.toReviewItem() },
            onSelect = { selected ->
                onRatingChanged(reviewRating.copy(salaryDate = selected))
            },
        )
        ReviewRatingSection(
            selected = reviewRating.overtime,
            items = Overtime.entries.map { it.toReviewItem() },
            onSelect = { selected ->
                onRatingChanged(reviewRating.copy(overtime = selected))
            },
        )
        ReviewRatingSection(
            selected = reviewRating.workDifficulty,
            items = WorkDifficulty.entries.map { it.toReviewItem() },
            onSelect = { selected ->
                onRatingChanged(reviewRating.copy(workDifficulty = selected))
            },
        )
    }
}
