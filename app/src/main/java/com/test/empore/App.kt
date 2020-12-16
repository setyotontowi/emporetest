package com.test.empore

import android.app.Application
import com.test.empore.di.AppComponent
import com.test.empore.di.DaggerAppComponent

class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}