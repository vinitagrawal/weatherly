package me.vinitagrawal.weatherly.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.vinitagrawal.weatherly.api.WeatherService
import me.vinitagrawal.weatherly.di.ViewModelModule.ViewModelKey
import me.vinitagrawal.weatherly.network.NetworkFactory
import me.vinitagrawal.weatherly.repository.WeatherRepository
import me.vinitagrawal.weatherly.repository.WeatherRepositoryImpl
import me.vinitagrawal.weatherly.viewmodel.WeatherViewModel
import javax.inject.Singleton

@Module
class HomeModule {

    @Provides
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    fun providesWeatherViewModel(weatherRepository: WeatherRepository): ViewModel {
        return WeatherViewModel(weatherRepository)
    }

    @Provides
    fun providesWeatherRepository(networkFactory: NetworkFactory): WeatherRepository {
        return WeatherRepositoryImpl(networkFactory.getService(WeatherService::class.java))
    }

    @Singleton
    @Provides
    fun providesNetworkFactory() = NetworkFactory()
}