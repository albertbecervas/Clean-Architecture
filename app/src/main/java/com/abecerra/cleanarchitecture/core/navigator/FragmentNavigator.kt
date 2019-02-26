package com.abecerra.cleanarchitecture.core.navigator

import android.content.Intent
import android.support.v4.app.Fragment
import com.abecerra.cleanarchitecture.presentation.ui.maindetail.MainDetailActivity
import com.base.project.core.di.scopes.PerFragment
import javax.inject.Inject

@PerFragment
class FragmentNavigator @Inject constructor(private val fragment: Fragment) {

    fun navigateToMainDetailActivity() {
        with(fragment) {
            context?.let {
                startActivity(Intent(it, MainDetailActivity::class.java))
            }
        }
    }

}