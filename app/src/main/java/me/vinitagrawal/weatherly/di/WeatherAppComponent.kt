package me.vinitagrawal.weatherly.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import me.vinitagrawal.weatherly.HomeActivity
import me.vinitagrawal.weatherly.WeatherApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        WeatherDepsModule::class,
        HomeModule::class,
        ViewModelModule::class
    ]
)
interface WeatherAppComponent {

    fun inject(application: WeatherApplication)

    fun inject(homeActivity: HomeActivity)
}