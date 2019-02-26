package com.abecerra.cleanarchitecture.core.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.abecerra.cleanarchitecture.core.di.FragmentModule
import com.base.project.core.di.component.FragmentComponent
import com.abecerra.cleanarchitecture.core.utils.extensions.getAppComponent

abstract class BaseFragment : Fragment() {

    val fragmentComponent: FragmentComponent by lazy {
        getAppComponent().plus(FragmentModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}