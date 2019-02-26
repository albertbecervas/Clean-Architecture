package com.abecerra.cleanarchitecture.presentation.ui.maindetail

import android.os.Bundle
import android.view.MenuItem
import com.abecerra.cleanarchitecture.R
import com.abecerra.cleanarchitecture.core.base.BaseActivity

class MainDetailActivity : BaseActivity() {

//    @Inject
//    lateinit var viewModelFactory: ViewModelFactory
//
//    private var viewModel: MainDetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_detail)
//        activityComponent.inject(this)

//        viewModel = withViewModel(viewModelFactory) {
//
//        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            when (it.itemId) {
                android.R.id.home -> onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
