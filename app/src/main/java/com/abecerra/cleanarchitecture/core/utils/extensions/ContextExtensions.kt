package com.abecerra.cleanarchitecture.core.utils.extensions

import android.app.Activity
import android.app.Service
import android.arch.lifecycle.*
import android.content.Context
import android.content.res.Resources
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.abecerra.cleanarchitecture.core.App
import com.base.project.core.di.component.AppComponent

val Activity.app: App get() = application as App
val Fragment.app: App get() = activity?.application as App
val Service.app: App get() = application as App
val resources: Resources get() = App.getAppContext().resources
val context: Context get() = App.getAppContext()

fun AppCompatActivity.getAppComponent(): AppComponent = (app).appComponent
fun Fragment.getAppComponent(): AppComponent = (app).appComponent
fun Service.getAppComponent(): AppComponent = (app).appComponent

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> FragmentActivity.withViewModel(
    viewModelFactory: ViewModelProvider.Factory,
    body: T.() -> Unit
): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> Fragment.getViewModel(viewModelFactory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.withViewModel(
    viewModelFactory: ViewModelProvider.Factory,
    body: T.() -> Unit
): T {
    val vm = getViewModel<T>(viewModelFactory)
    vm.body()
    return vm
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun setPriceWithIva(textView: TextView, price: String) {
    val iva = " +iva"
    val ss1 = SpannableString(iva)
    ss1.setSpan(RelativeSizeSpan(0.5f), 0, ss1.length, 0)
    textView.text = ""
    textView.append(price)
    textView.append(ss1)
}


val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()