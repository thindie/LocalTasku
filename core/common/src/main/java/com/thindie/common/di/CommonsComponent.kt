package com.thindie.common.di

import com.thindie.common.CommonProvider
import com.thindie.common.di.dispatchers.DispatchersModule
import com.thindie.common.di.viewmodels_factory.ViewModelFactoryModule
import com.thindie.common.timemanagement.di.DateTimeFormatterModule
import com.thindie.common.timemanagement.di.LocaleModule
import com.thindie.common.timemanagement.di.TimeOperatorModule
import com.thindie.common.timemanagement.di.TimeZoneModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DispatchersModule::class,
    TimeOperatorModule::class,
    DateTimeFormatterModule::class,
    LocaleModule::class,
    TimeZoneModule::class])
interface CommonsComponent: CommonProvider {
    companion object{
        fun init(): CommonsComponent {
            return DaggerCommonsComponent
                .factory()
                .create()
        }

    }

    @Component.Factory
    interface Factory {
        fun create(): CommonsComponent
    }
}