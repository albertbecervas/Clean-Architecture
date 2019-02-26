package com.abecerra.cleanarchitecture.core.navigator

import android.content.Intent
import android.support.v4.app.Fragment
import com.abecerra.cleanarchitecture.presentation.ui.main.MainActivity
import com.base.project.core.di.scopes.PerFragment
import javax.inject.Inject

@PerFragment
class FragmentNavigator @Inject constructor(private val fragment: Fragment) : Navigator {

    override fun navigateToMainActivity() {
        with(fragment) {
            startActivity(Intent(context, MainActivity::class.java))
        }
    }

}