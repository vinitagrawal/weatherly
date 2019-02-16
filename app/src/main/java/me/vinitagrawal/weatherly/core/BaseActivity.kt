package me.vinitagrawal.weatherly.core

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import me.vinitagrawal.weatherly.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity<E: ViewModel>(private val viewModelClass: Class<E>) : AppCompatActivity() {

    protected lateinit var viewModel: E

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }
}