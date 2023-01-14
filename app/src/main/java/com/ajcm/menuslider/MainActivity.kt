package com.ajcm.menuslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.ajcm.menuslider.carousel.CarouselMenu
import com.ajcm.menuslider.theme.AppTheme

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
            CarouselMenu()
        }
    }
}
