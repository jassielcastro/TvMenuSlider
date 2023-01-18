package com.ajcm.menuslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.ajcm.menuslider.ui.carousel.CarouselMenu
import com.ajcm.menuslider.theme.AppTheme
import com.ajcm.menuslider.ui.carousel.viewModel.MenuSliderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LandingPage()
        }
    }

    @Composable
    fun LandingPage() {
        AppTheme {
            val viewModel: MenuSliderViewModel by viewModels()
            CarouselMenu(viewModel)
        }
    }
}
