package com.ajcm.menuslider.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ajcm.menuslider.R

private val bigTextSize = 80.sp

private val bevanFamily = FontFamily(
    Font(R.font.bevan, FontWeight.Normal)
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = bevanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = bigTextSize
    )
)

val LocalTypography = staticCompositionLocalOf { Typography }
