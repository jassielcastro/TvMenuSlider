package com.ajcm.menuslider.ui.carousel

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.ajcm.menuslider.model.MenuItem
import com.ajcm.menuslider.ui.carousel.viewModel.MenuSliderViewModel
import kotlinx.coroutines.delay

@Composable
fun CarouselMenu(
    viewModel: MenuSliderViewModel
) {

    val imagesList by viewModel.imageSlides.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.downloadImageSlides()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        if (imagesList.isEmpty()) {
            LoadingImages()
        } else {
            CarouselMenu(imagesList)
        }
    }
}

@Composable
fun LoadingImages() {
    Text(
        text = "Menu Slider",
        fontStyle = MaterialTheme.typography.headlineLarge.fontStyle,
        color = MaterialTheme.colorScheme.primary
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CarouselMenu(
    listOfImages: List<MenuItem> = listOf()
) {

    var menuIndex by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = listOfImages) {
        while (true) {
            delay(3_000L)
            if (menuIndex == listOfImages.size - 1) {
                menuIndex = 0
            } else {
                menuIndex += 1
            }
        }
    }

    AnimatedContent(targetState = menuIndex) { index ->
        Text(
            text = listOfImages[index].title,
            fontStyle = MaterialTheme.typography.headlineLarge.fontStyle,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(device = Devices.DESKTOP, showSystemUi = true)
@Composable
fun CarouselPreview() {
    CarouselMenu()
}
