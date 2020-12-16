package com.test.empore.di

import android.content.Context
import com.test.empore.activity.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface factory{
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}