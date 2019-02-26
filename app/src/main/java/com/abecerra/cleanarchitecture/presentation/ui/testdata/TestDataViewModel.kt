package com.abecerra.cleanarchitecture.presentation.ui.testdata

import android.arch.lifecycle.MutableLiveData
import com.abecerra.cleanarchitecture.presentation.model.TestData
import com.abecerra.cleanarchitecture.presentation.model.mapper.TestDataMapper
import com.abecerra.cleanarchitecture.core.base.BaseViewModel
import com.abecerra.cleanarchitecture.core.utils.AppSharedPreferences
import com.abecerra.cleanarchitecture.core.utils.extensions.Data
import com.abecerra.cleanarchitecture.core.utils.extensions.DataState
import com.abecerra.cleanarchitecture.core.utils.extensions.addToCompositeDisposable
import com.abecerra.cleanarchitecture.domain.usecase.TestDataUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TestDataViewModel @Inject constructor(
    private val useCase: TestDataUseCase,
    private val testDataMapper: TestDataMapper
) : BaseViewModel() {

    @Inject
    lateinit var mPrefs: AppSharedPreferences

    val testDataApi = MutableLiveData<Data<TestData>>()
    val testDataDb = MutableLiveData<Data<TestData>>()
    val testDataPrefs = MutableLiveData<Data<String>>()

    fun getTestApi() {
        useCase.getTestApi()
            .doOnSubscribe {
                testDataApi.postValue(
                    Data(
                        dataState = DataState.LOADING,
                        data = testDataApi.value?.data,
                        message = null
                    )
                )
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                testDataApi.postValue(
                    Data(
                        dataState = DataState.SUCCESS,
                        data = testDataMapper.map(it),
                        message = null
                    )
                )
                mPrefs.setTestPreference(testDataMapper.map(it).testData)

            }, {
                testDataApi.postValue(
                    Data(
                        dataState = DataState.ERROR,
                        data = null,
                        message = it.message
                    )
                )
            }).addToCompositeDisposable(compositeDisposable)
    }

    fun getTestDb() {
        useCase.getTestDb()
            .doOnSubscribe {
                testDataDb.postValue(
                    Data(
                        dataState = DataState.LOADING,
                        data = testDataApi.value?.data,
                        message = null
                    )
                )
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                testDataDb.postValue(
                    Data(
                        dataState = DataState.SUCCESS,
                        data = testDataMapper.map(it),
                        message = null
                    )
                )
            }, {
                testDataDb.postValue(
                    Data(
                        dataState = DataState.ERROR,
                        data = null,
                        message = it.message
                    )
                )
            }).addToCompositeDisposable(compositeDisposable)
    }

    fun getTestPrefs() {
        testDataPrefs.postValue(
            Data(
                dataState = DataState.SUCCESS,
                data = mPrefs.getTestPreference(),
                message = null
            )
        )
    }

}