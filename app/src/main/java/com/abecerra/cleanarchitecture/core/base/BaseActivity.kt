package com.abecerra.cleanarchitecture.core.base

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.abecerra.cleanarchitecture.core.di.ActivityModule
import com.abecerra.cleanarchitecture.core.utils.extensions.getAppComponent
import com.base.project.core.di.component.ActivityComponent
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val activityComponent: ActivityComponent by lazy {
        getAppComponent().plus(ActivityModule(this))
    }

}
