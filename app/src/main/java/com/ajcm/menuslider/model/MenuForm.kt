package com.ajcm.menuslider.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.ajcm.menuslider.R

sealed interface MenuForm

enum class Stroke(@DrawableRes val imgRes: Int) {
    ZIGZAG_STROKE(R.drawable.zigzag_orange_stroke),
    TOP_BOTTOM_LINES(R.drawable.top_bottom_dots_stroke),
    SQARE_DOTS_STROKE(R.drawable.sqare_dots_stroke)
}

data class ShowTowOptions(
    @DrawableRes val image: Int,
    val option1: MenuItem,
    val option2: MenuItem,
    val stroke: Stroke,
    val backgroundColor: Color,
    val strokeTint: Color
) : MenuForm

data class ShowThreeOptions(
    @DrawableRes val image: Int,
    val title: String,
    val option1: MenuItem,
    val option2: MenuItem,
    val option3: MenuItem,
    val type: Type,
    val stroke: Stroke,
    val backgroundColor: Color,
    val strokeTint: Color
) : MenuForm {
    enum class Type {
        COMPLETE_START, COMPLETE_END, INDIVIDUAL
    }
}
