package com.abecerra.cleanarchitecture.presentation.ui.testdata


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abecerra.cleanarchitecture.R
import com.abecerra.cleanarchitecture.presentation.model.TestData
import com.abecerra.cleanarchitecture.core.base.BaseFragment
import com.abecerra.cleanarchitecture.core.navigator.FragmentNavigator
import com.abecerra.cleanarchitecture.core.utils.extensions.*
import kotlinx.android.synthetic.main.fragment_test_data.*
import javax.inject.Inject


class TestDataFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var navigator: FragmentNavigator

    private var viewModel: TestDataViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentComponent.inject(this)

        viewModel = withViewModel(viewModelFactory) {
            observe(testDataApi, ::onTestDataApi)
            observe(testDataDb, ::onTestDataDb)
            observe(testDataPrefs, ::onTestDataPrefs)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btApi.setOnClickListener {
            viewModel?.getTestApi()
        }

        btDb.setOnClickListener {
            viewModel?.getTestDb()
        }

        btPrefs.setOnClickListener {
            viewModel?.getTestPrefs()
        }

    }

    private fun onTestDataApi(data: Data<TestData>?) {
        data?.let {
            when {
                it.dataState == DataState.SUCCESS -> {
                    tvApiData.text = it.data?.testData
                }
            }
        }
    }

    private fun onTestDataDb(data: Data<TestData>?) {
        data?.let {
            when {
                it.dataState == DataState.SUCCESS -> {
                    tvDbData.text = it.data?.testData
                }
            }
        }
    }

    private fun onTestDataPrefs(data: Data<String>?) {
        data?.let {
            when {
                it.dataState == DataState.SUCCESS -> {
                    tvPrefsData.text = it.data
                }
            }
        }
    }

}
