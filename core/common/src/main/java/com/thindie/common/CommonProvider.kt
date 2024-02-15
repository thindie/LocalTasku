package com.thindie.common

import com.thindie.common.di.IODispatcher
import com.thindie.common.timemanagement.TimeOperator
import kotlinx.coroutines.CoroutineDispatcher

interface CommonProvider {
    @IODispatcher
    fun provideCoroutineDispatcher(): CoroutineDispatcher

    fun provideTimeOperator(): TimeOperator
}