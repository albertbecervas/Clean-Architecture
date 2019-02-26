package com.abecerra.cleanarchitecture.core.di


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.abecerra.cleanarchitecture.presentation.ui.main.MainViewModel
import com.abecerra.cleanarchitecture.presentation.ui.testdata.TestDataViewModel
import com.abecerra.cleanarchitecture.core.utils.extensions.ViewModelFactory
import com.abecerra.cleanarchitecture.core.utils.extensions.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestDataViewModel::class)
    internal abstract fun testDataViewModel(viewModel: TestDataViewModel): ViewModel


}
