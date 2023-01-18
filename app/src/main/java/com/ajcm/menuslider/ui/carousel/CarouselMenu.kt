package com.ajcm.menuslider.ui.carousel

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.ajcm.menuslider.model.MenuItem
import com.ajcm.menuslider.ui.carousel.viewModel.MenuSliderViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun CarouselMenu(
    viewModel: MenuSliderViewModel
) {

    val imagesList by viewModel.imageSlides.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.downloadImageSlides()
    }

    if (imagesList.isEmpty()) {
        LoadingImages()
    } else {
        CarouselMenu(imagesList, viewModel)
    }
}

@Composable
fun LoadingImages() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Loading...",
            fontStyle = MaterialTheme.typography.headlineLarge.fontStyle,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun CarouselMenu(
    listOfImages: List<MenuItem> = listOf(),
    viewModel: MenuSliderViewModel
) {

    val menuIndex by viewModel.indexStep.collectAsState()

    LaunchedEffect(listOfImages) {
        viewModel.generateSteps(listOfImages)
    }

    AnimatedContent(
        targetState = menuIndex,
        transitionSpec = {
            slideIf { targetState > initialState }
        }
    ) { index ->
        val image = listOfImages[index]
        GlideImage(
            model = image.imageUrl,
            contentDescription = image.title,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun slideIf(isFromLeft: () -> Boolean): ContentTransform {
    return if (isFromLeft()) {
        slideInHorizontally(
            animationSpec = tween(300),
            initialOffsetX = { fullWidth -> fullWidth }
        ) with slideOutHorizontally(
            animationSpec = tween(300),
            targetOffsetX = { fullWidth -> -fullWidth }
        )
    } else {
        slideInHorizontally(
            animationSpec = tween(300),
            initialOffsetX = { fullWidth -> -fullWidth }
        ) with slideOutHorizontally(
            animationSpec = tween(300),
            targetOffsetX = { fullWidth -> fullWidth }
        )
    }
}

@Preview(device = Devices.DESKTOP, showSystemUi = true)
@Composable
fun CarouselPreview() {
    LoadingImages()
}
