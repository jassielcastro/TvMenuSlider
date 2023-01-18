package com.ajcm.menuslider.ui.carousel.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajcm.menuslider.model.MenuItem
import com.ajcm.menuslider.usecase.GetMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuSliderViewModel @Inject constructor(
    private val getMenuUseCase: GetMenuUseCase
) : ViewModel() {

    private val mImageSlides = MutableSharedFlow<List<MenuItem>>()
    val imageSlides = mImageSlides
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            emptyList()
        )

    private val mIndexStep = MutableSharedFlow<Int>()
    val indexStep = mIndexStep
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            0
        )

    fun downloadImageSlides() {
        getMenuUseCase {
            viewModelScope.launch {
                mImageSlides.emit(it)
            }
        }
    }

    fun generateSteps(listOfImages: List<MenuItem>) = viewModelScope.launch {
        while (true) {
            delay(3_000L)
            if (indexStep.value == listOfImages.size - 1) {
                mIndexStep.emit(0)
            } else {
                mIndexStep.emit(indexStep.value + 1)
            }
        }
    }
}
