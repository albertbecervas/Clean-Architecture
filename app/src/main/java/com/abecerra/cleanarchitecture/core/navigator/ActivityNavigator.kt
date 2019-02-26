package com.abecerra.cleanarchitecture.core.navigator

import android.app.Activity
import com.abecerra.cleanarchitecture.core.di.scopes.PerActivity
import com.abecerra.cleanarchitecture.presentation.ui.main.MainActivity
import org.jetbrains.anko.intentFor
import javax.inject.Inject

@PerActivity
class ActivityNavigator @Inject constructor(private var activity: Activity) : Navigator {

    override fun navigateToMainActivity() {
        with(activity) {
            startActivity(intentFor<MainActivity>())
        }
    }


}