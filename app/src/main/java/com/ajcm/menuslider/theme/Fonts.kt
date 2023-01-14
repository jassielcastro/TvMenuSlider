package com.ajcm.menuslider.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ajcm.menuslider.R

private val bigTextSize = 36.sp
private val normalTextSize = 24.sp
private val mediumTextSize = 18.sp
private val smallTextSize = 14.sp

private val bevanFamily = FontFamily(
    Font(R.font.bevan, FontWeight.Normal)
)

private val montserratFamily = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal)
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = bevanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = bigTextSize
    ),
    titleLarge = TextStyle(
        fontFamily = bevanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = normalTextSize
    ),
    titleMedium = TextStyle(
        fontFamily = bevanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = smallTextSize
    ),
    bodyLarge = TextStyle(
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Normal,
        fontSize = mediumTextSize
    ),
)

val LocalTypography = staticCompositionLocalOf { Typography }
