package me.vinitagrawal.weatherly

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import me.vinitagrawal.weatherly.di.DaggerWeatherAppComponent
import javax.inject.Inject

class WeatherApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerWeatherAppComponent.create()
            .inject(this)
    }

    override fun activityInjector() = dispatchingActivityInjector
}