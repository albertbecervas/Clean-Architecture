package com.base.project.core.di.component

import com.abecerra.cleanarchitecture.core.di.ActivityModule
import com.abecerra.cleanarchitecture.core.di.scopes.PerActivity
import com.abecerra.cleanarchitecture.presentation.ui.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}