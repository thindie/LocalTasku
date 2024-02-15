package com.thindie.localtasku.application

import android.app.Application
import com.thindie.localtasku.di.AppComponent
import com.thindie.common.App
import com.thindie.common.DependenciesProvider

class TaskuApplication: Application(), App {


    private var appComponent: AppComponent? = null
    override fun getDependenciesProvider(): DependenciesProvider {
       if (appComponent == null) appComponent = AppComponent.init(this)
        return requireNotNull(appComponent)
    }
}