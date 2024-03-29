package com.thindie.common.timemanagement.di

import dagger.Module
import dagger.Provides

import java.util.*
import javax.inject.Singleton

@Module
internal class TimeZoneModule {
    @Provides
    @Singleton
    fun provideTimeZone(): TimeZone {
        return TimeZone.getDefault()
    }
}