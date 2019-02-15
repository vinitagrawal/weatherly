package me.vinitagrawal.weatherly.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.vinitagrawal.weatherly.HomeActivity

@Module
abstract class WeatherDepsModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeScreenInjector(): HomeActivity
}