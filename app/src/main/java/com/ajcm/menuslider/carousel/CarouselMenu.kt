package com.ajcm.menuslider.carousel

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.ajcm.menuslider.model.MenuForm
import com.ajcm.menuslider.model.MenuItem
import com.ajcm.menuslider.model.ShowTowOptions
import com.ajcm.menuslider.model.Stroke
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CarouselMenu() {
    val colorScheme = MaterialTheme.colorScheme

    val menu by remember {
        mutableStateOf(
            listOf(
                ShowTowOptions(
                    image = androidx.appcompat.R.drawable.btn_checkbox_checked_mtrl,
                    option1 = MenuItem("", "", 0.0),
                    option2 = MenuItem("", "", 0.0),
                    stroke = Stroke.SQARE_DOTS_STROKE,
                    backgroundColor = colorScheme.background,
                    strokeTint = colorScheme.tertiary,
                ),
                ShowTowOptions(
                    image = androidx.appcompat.R.drawable.btn_checkbox_checked_mtrl,
                    option1 = MenuItem("", "", 0.0),
                    option2 = MenuItem("", "", 0.0),
                    stroke = Stroke.ZIGZAG_STROKE,
                    backgroundColor = colorScheme.primary,
                    strokeTint = colorScheme.tertiary,
                ),
                ShowTowOptions(
                    image = androidx.appcompat.R.drawable.btn_checkbox_checked_mtrl,
                    option1 = MenuItem("", "", 0.0),
                    option2 = MenuItem("", "", 0.0),
                    stroke = Stroke.TOP_BOTTOM_LINES,
                    backgroundColor = colorScheme.primary,
                    strokeTint = colorScheme.tertiary,
                )
            )
        )
    }
    var menuIndex by remember { mutableStateOf(0) }
    var step: MenuForm by remember { mutableStateOf(menu[menuIndex]) }

    LaunchedEffect(key1 = step) {
        while (true) {
            delay(3_000L)
            if (menuIndex == menu.size - 1) {
                menuIndex = 0
            } else {
                menuIndex += 1
            }
            step = menu[menuIndex]
        }
    }

    AnimatedContent(targetState = step) { screen ->
        when (screen) {
            is ShowTowOptions -> {
                ShowTwoOptionMenu(
                    option = screen
                )
            }
            else -> {}
        }

    }
}

@Preview(device = Devices.DESKTOP, showSystemUi = true)
@Composable
fun CarouselPreview() {
    CarouselMenu()
}
