package com.konkuk.arabyte_aos.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor() : ViewModel() {
        private val _showSplash = MutableStateFlow(true)
        val showSplash: StateFlow<Boolean> = _showSplash

        fun startSplashTimer() {
            viewModelScope.launch {
                delay(SPLASH_SCREEN_DELAY)
                _showSplash.value = false
            }
        }

        companion object {
            const val SPLASH_SCREEN_DELAY = 2000L
        }
    }
