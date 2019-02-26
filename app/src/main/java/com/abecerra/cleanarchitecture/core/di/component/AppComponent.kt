package com.base.project.core.di.component

import com.abecerra.cleanarchitecture.core.di.ActivityModule
import com.abecerra.cleanarchitecture.core.di.AppModule
import com.abecerra.cleanarchitecture.core.di.FragmentModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent
    operator fun plus(fragmentModule: FragmentModule): FragmentComponent

}
