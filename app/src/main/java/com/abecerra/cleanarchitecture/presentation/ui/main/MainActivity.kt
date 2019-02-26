package com.abecerra.cleanarchitecture.presentation.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import com.abecerra.cleanarchitecture.R
import com.abecerra.cleanarchitecture.core.utils.BarAdapter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.abecerra.cleanarchitecture.core.base.BaseActivity
import com.abecerra.cleanarchitecture.core.navigator.ActivityNavigator
import com.abecerra.cleanarchitecture.core.utils.AppSharedPreferences
import com.abecerra.cleanarchitecture.core.utils.extensions.withViewModel
import com.abecerra.cleanarchitecture.presentation.ui.Test2Fragment
import com.abecerra.cleanarchitecture.presentation.ui.Test3Fragment
import com.abecerra.cleanarchitecture.presentation.ui.testdata.TestDataFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: ActivityNavigator

    @Inject
    lateinit var mPrefs: AppSharedPreferences

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)

        viewModel = withViewModel(viewModelFactory) {}

        setViewPager()
        setupBottomNavMenu()

    }

    private fun setViewPager(currentPosition: Int = -1) {

        val pagerAdapter = BarAdapter(supportFragmentManager)

        pagerAdapter.addFragments(TestDataFragment(), "MVP")
        pagerAdapter.addFragments(Test2Fragment(), "in progress")
        pagerAdapter.addFragments(Test3Fragment(), "history")

        viewPager.setPagingEnabled(false)
        viewPager.offscreenPageLimit = 2
        viewPager.adapter = pagerAdapter

        if (currentPosition != -1 && currentPosition < pagerAdapter.count) viewPager.currentItem =
            currentPosition
    }

    private fun setupBottomNavMenu() {

        val pending = AHBottomNavigationItem("MVP", R.drawable.ic_launcher_background)
        val current = AHBottomNavigationItem("MVP", R.drawable.ic_launcher_background)
        val history = AHBottomNavigationItem("MVP", R.drawable.ic_launcher_background)

        val itemList = arrayListOf(pending, current, history)
        bottomNavigationView.addItems(itemList)
//        bottomNavigationView.defaultBackgroundColor = ContextCompat.getColor(this, R.color.innroute_default)
//        bottomNavigationView.accentColor = ContextCompat.getColor(this, R.color.innroute_soft_blue)

//        bottomNavigationView.setNotificationBackgroundColor(ContextCompat.getColor(this, R.color.innroute_red))
//        bottomNavigationView.setNotificationTextColorResource(R.color.innroute_white)

        bottomNavigationView.setOnTabSelectedListener { position, wasSelected ->
            if (!wasSelected) switchFragment(position)
            true
        }

    }

    private fun switchFragment(id: Int) {
        viewPager.setCurrentItem(id, false)

        when (id) {
            0 -> {
                supportActionBar?.title = "MVP pattern"
            }
            1 -> {
                supportActionBar?.title = "Test 2"
            }
            2 -> {
                supportActionBar?.title = "Test 3"
            }
            else -> {
                supportActionBar?.title = getString(R.string.app_name)
            }
        }
    }

}
