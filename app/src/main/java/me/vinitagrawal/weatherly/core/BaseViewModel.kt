package me.vinitagrawal.weatherly.core

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    abstract fun onRender()
}