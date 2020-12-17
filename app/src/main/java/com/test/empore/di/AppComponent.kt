package com.test.empore.di

import android.content.Context
import com.test.empore.data.remote.NetworkModule
import com.test.empore.ui.activity.MainActivity
import com.test.empore.ui.fragment.FavoriteFragment
import com.test.empore.ui.fragment.HomeFragment
import com.test.empore.ui.fragment.RecentFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(favoriteFragment: FavoriteFragment)
    fun inject(recentFragment: RecentFragment)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}