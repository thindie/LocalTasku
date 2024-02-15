package com.thindie.common.coreartifacts

import androidx.lifecycle.ViewModelProvider

interface InjectionComponent {
    fun provideFactory(): ViewModelProvider.Factory
}