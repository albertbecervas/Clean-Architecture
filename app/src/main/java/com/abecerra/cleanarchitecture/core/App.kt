package com.abecerra.cleanarchitecture.core

import android.content.Context
import android.support.multidex.MultiDexApplication
import com.abecerra.cleanarchitecture.BuildConfig
import com.abecerra.cleanarchitecture.core.di.AppModule
import com.base.project.core.di.component.AppComponent
import com.base.project.core.di.component.DaggerAppComponent
import timber.log.Timber

class App : MultiDexApplication() {

    lateinit var appComponent: AppComponent private set

    companion object {

        lateinit var INSTANCE: App

        fun getAppContext(): App = INSTANCE

        fun get(context: Context): App {
            return context.applicationContext as App
        }

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initDagger()
        initTimber()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}