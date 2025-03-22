package com.konkuk.arabyte_aos.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.konkuk.arabyte_aos.R

sealed class ArabyteTopAppBarType(
    @DrawableRes val backButtonIconRes: Int = R.drawable.ic_all_back_button_45,
) {
    object BackButtonOnly : ArabyteTopAppBarType()

    data class BackButtonWithTitle(
        @StringRes val titleStringRes: Int,
    ) : ArabyteTopAppBarType()

    data class BackButtonWithTitleAndOption(
        @StringRes val titleStringRes: Int,
        @StringRes val optionalButtonStringRes: Int,
    ) : ArabyteTopAppBarType()

    data class BackButtonWithOptionalIcon(
        @DrawableRes val optionalIconRes: Int = R.drawable.ic_all_optional_button_45,
    ) : ArabyteTopAppBarType()
}
