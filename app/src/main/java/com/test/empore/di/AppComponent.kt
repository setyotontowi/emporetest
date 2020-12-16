package com.test.empore.di

import android.content.Context
import com.test.empore.activity.MainActivity
import com.test.empore.fragment.FavoriteFragment
import com.test.empore.fragment.HomeFragment
import com.test.empore.fragment.RecentFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(favoriteFragment: FavoriteFragment)
    fun inject(recentFragment: RecentFragment)

    @Component.Factory
    interface factory{
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}