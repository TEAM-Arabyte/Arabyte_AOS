package com.konkuk.arabyte_aos.domain.model

import com.konkuk.arabyte_aos.domain.util.ReviewRatingTexts
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory

data class ReviewDetail(
    val reviewId: Int,
    val companyName: String,
    val isCertified: Boolean,
    val star: Int,
    val region: String,
    val category: ArabyteJobCategory,
    val reviewRating: ReviewRating,
    val reviewContent: String,
)

data class ReviewRating(
    val workIntensity: WorkIntensity,
    val workAtmosphere: WorkAtmosphere,
    val salary: Salary,
    val salaryDate: SalaryDate,
    val overtime: Overtime,
    val workDifficulty: WorkDifficulty,
)

enum class WorkIntensity(val label: String) {
    LIGHT(ReviewRatingTexts.LABEL_WORK_INTENSITY_LIGHT),
    MODERATE(ReviewRatingTexts.LABEL_WORK_INTENSITY_MODERATE),
    HEAVY(ReviewRatingTexts.LABEL_WORK_INTENSITY_HEAVY),
    ;

    val title: String = ReviewRatingTexts.TITLE_WORK_INTENSITY
    val ask: String = ReviewRatingTexts.ASK_WORK_INTENSITY
}

enum class WorkAtmosphere(val label: String) {
    COMFORTABLE(ReviewRatingTexts.LABEL_WORK_ATMOSPHERE_COMFORTABLE),
    NEUTRAL(ReviewRatingTexts.LABEL_WORK_ATMOSPHERE_NEUTRAL),
    RIGID(ReviewRatingTexts.LABEL_WORK_ATMOSPHERE_RIGID),
    ;

    val title: String = ReviewRatingTexts.TITLE_WORK_ATMOSPHERE
    val ask: String = ReviewRatingTexts.ASK_WORK_ATMOSPHERE
}

enum class Salary(val label: String) {
    LOW_THEN_MINIMUM(ReviewRatingTexts.LABEL_SALARY_LOW),
    MINIMUM(ReviewRatingTexts.LABEL_SALARY_MIN),
    AVERAGE(ReviewRatingTexts.LABEL_SALARY_AVG),
    HIGH(ReviewRatingTexts.LABEL_SALARY_HIGH),
    ;

    val title: String = ReviewRatingTexts.TITLE_SALARY
    val ask: String = ReviewRatingTexts.ASK_SALARY
}

enum class SalaryDate(val label: String) {
    REGULARLY(ReviewRatingTexts.LABEL_SALARY_DATE_REGULAR),
    DELAYED_SOMETIMES(ReviewRatingTexts.LABEL_SALARY_DATE_DELAY),
    IRREGULARLY(ReviewRatingTexts.LABEL_SALARY_DATE_IRREGULAR),
    ;

    val title: String = ReviewRatingTexts.TITLE_SALARY_DATE
    val ask: String = ReviewRatingTexts.ASK_SALARY_DATE
}

enum class Overtime(val label: String) {
    HARDLY(ReviewRatingTexts.LABEL_OVERTIME_NONE),
    SOMETIMES(ReviewRatingTexts.LABEL_OVERTIME_SOMETIMES),
    REGULARLY(ReviewRatingTexts.LABEL_OVERTIME_FREQUENT),
    ;

    val title: String = ReviewRatingTexts.TITLE_OVERTIME
    val ask: String = ReviewRatingTexts.ASK_OVERTIME
}

enum class WorkDifficulty(val label: String) {
    EASY(ReviewRatingTexts.LABEL_WORK_DIFFICULTY_EASY),
    MODERATE(ReviewRatingTexts.LABEL_WORK_DIFFICULTY_MODERATE),
    HARD(ReviewRatingTexts.LABEL_WORK_DIFFICULTY_HARD),
    ;

    val title: String = ReviewRatingTexts.TITLE_WORK_DIFFICULTY
    val ask: String = ReviewRatingTexts.ASK_WORK_DIFFICULTY
}

interface ReviewRatingItem {
    val label: String
    val title: String
    val ask: String
}

data class ReviewRatingItemWrapper<T : Enum<T>>(
    val value: T,
    override val label: String,
    override val title: String,
    override val ask: String,
) : ReviewRatingItem

fun ReviewRating.toTitleLabelList(): List<Pair<String, String>> {
    return listOf(
        salary.title to salary.label,
        salaryDate.title to salaryDate.label,
        overtime.title to overtime.label,
        workAtmosphere.title to workAtmosphere.label,
        workDifficulty.title to workDifficulty.label,
        workIntensity.title to workIntensity.label,
    )
}

fun WorkIntensity.toReviewItem() =
    ReviewRatingItemWrapper(
        value = this,
        label = this.label,
        title = ReviewRatingTexts.TITLE_WORK_INTENSITY,
        ask = ReviewRatingTexts.ASK_WORK_INTENSITY,
    )

fun WorkAtmosphere.toReviewItem() =
    ReviewRatingItemWrapper(
        value = this,
        label = this.label,
        title = ReviewRatingTexts.TITLE_WORK_ATMOSPHERE,
        ask = ReviewRatingTexts.ASK_WORK_ATMOSPHERE,
    )

fun Salary.toReviewItem() =
    ReviewRatingItemWrapper(
        value = this,
        label = this.label,
        title = ReviewRatingTexts.TITLE_SALARY,
        ask = ReviewRatingTexts.ASK_SALARY,
    )

fun SalaryDate.toReviewItem() =
    ReviewRatingItemWrapper(
        value = this,
        label = this.label,
        title = ReviewRatingTexts.TITLE_SALARY_DATE,
        ask = ReviewRatingTexts.ASK_SALARY_DATE,
    )

fun Overtime.toReviewItem() =
    ReviewRatingItemWrapper(
        value = this,
        label = this.label,
        title = ReviewRatingTexts.TITLE_OVERTIME,
        ask = ReviewRatingTexts.ASK_OVERTIME,
    )

fun WorkDifficulty.toReviewItem() =
    ReviewRatingItemWrapper(
        value = this,
        label = this.label,
        title = ReviewRatingTexts.TITLE_WORK_DIFFICULTY,
        ask = ReviewRatingTexts.ASK_WORK_DIFFICULTY,
    )
