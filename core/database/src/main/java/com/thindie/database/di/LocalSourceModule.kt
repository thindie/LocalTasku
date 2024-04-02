package com.thindie.database.di

import com.thindie.database.LocalSource
import com.thindie.database.entities.LocalSourceProviderImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface LocalSourceModule {

    @Singleton
    @Binds
    fun bindLocalSourceRepository(impl: LocalSourceProviderImpl): LocalSource
}