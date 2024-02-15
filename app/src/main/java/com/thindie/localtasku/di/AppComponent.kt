package com.thindie.localtasku.di

import com.thindie.common.DependenciesProvider
import com.thindie.common.CommonProvider
import com.thindie.common.di.CommonsComponent
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [ CommonProvider::class],
)
@Singleton
interface AppComponent : DependenciesProvider {
    companion object {
        fun init(): AppComponent {
            val commonProvider: CommonProvider = CommonsComponent.init()


            return DaggerAppComponent
                .factory()
                .create(commonProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            commonProvider: CommonProvider,
        ): AppComponent
    }
}