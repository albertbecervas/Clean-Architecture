package com.abecerra.cleanarchitecture.core.di

import android.support.v4.app.Fragment
import com.base.project.core.di.scopes.PerFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @PerFragment
    fun provideFragment(): Fragment = this.fragment

}