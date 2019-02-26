package com.abecerra.cleanarchitecture.core.base

import android.support.v4.app.Fragment
import com.abecerra.cleanarchitecture.core.di.FragmentModule
import com.abecerra.cleanarchitecture.core.utils.extensions.ViewModelFactory
import com.abecerra.cleanarchitecture.core.utils.extensions.getAppComponent
import com.base.project.core.di.component.FragmentComponent
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val fragmentComponent: FragmentComponent by lazy {
        getAppComponent().plus(FragmentModule(this))
    }

}