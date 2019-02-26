package com.abecerra.cleanarchitecture.core.navigator

import android.app.Activity
import android.content.Intent
import com.abecerra.cleanarchitecture.core.di.scopes.PerActivity
import com.abecerra.cleanarchitecture.presentation.ui.maindetail.MainDetailActivity
import javax.inject.Inject

@PerActivity
class ActivityNavigator @Inject constructor(private var activity: Activity) {

    fun navigateToMainDetailActivity() {
        with(activity) {
            startActivity(Intent(this, MainDetailActivity::class.java))
        }
    }

}