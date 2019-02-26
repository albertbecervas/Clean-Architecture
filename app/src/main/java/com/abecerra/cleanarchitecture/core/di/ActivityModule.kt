package com.abecerra.cleanarchitecture.core.di

import android.app.Activity
import com.abecerra.cleanarchitecture.core.di.scopes.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @PerActivity
    internal fun provideActivity(): Activity = this.activity


}