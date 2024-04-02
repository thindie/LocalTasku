package com.thindie.database.di

import com.thindie.database.LocalSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface LocalSourceModule {

    @Singleton
    @Binds
    fun bindLocalSourceRepository(): LocalSource
}