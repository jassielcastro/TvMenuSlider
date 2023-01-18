package com.ajcm.menuslider.ui.carousel.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajcm.menuslider.model.MenuItem
import com.ajcm.menuslider.usecase.GetMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun downloadImageSlides() {
        getMenuUseCase {
            viewModelScope.launch {
                mImageSlides.emit(it)
            }
        }
    }
}
