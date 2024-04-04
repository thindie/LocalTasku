package com.thindie.localtasku.di

import android.content.Context
import com.thindie.common.CommonProvider
import com.thindie.common.DependenciesProvider
import com.thindie.common.di.CommonsComponent
import com.thindie.database.di.LocalSourceComponent
import com.thindie.database.LocalSourceProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [CommonProvider::class, LocalSourceProvider::class],
)
@Singleton
interface AppComponent : DependenciesProvider {
    companion object {
        fun init(context: Context): AppComponent {
            val commonProvider: CommonProvider = CommonsComponent.init()
            val localSourceProvider = LocalSourceComponent.init(context)

            return DaggerAppComponent
                .factory()
                .create(context, commonProvider, localSourceProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            commonProvider: CommonProvider,
            localSourceProvider: LocalSourceProvider,
        ): AppComponent
    }
}