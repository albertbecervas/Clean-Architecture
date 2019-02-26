package com.base.project.core.di.component

import com.abecerra.cleanarchitecture.core.di.FragmentModule
import com.base.project.core.di.scopes.PerFragment
import com.abecerra.cleanarchitecture.presentation.ui.testdata.TestDataFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(testDataFragment: TestDataFragment)

}