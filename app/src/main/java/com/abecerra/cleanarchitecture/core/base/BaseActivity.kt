package com.abecerra.cleanarchitecture.core.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abecerra.cleanarchitecture.core.di.ActivityModule
import com.base.project.core.di.component.ActivityComponent
import com.abecerra.cleanarchitecture.core.utils.extensions.getAppComponent

abstract class BaseActivity : AppCompatActivity() {

    val activityComponent: ActivityComponent by lazy {
        getAppComponent().plus(ActivityModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
