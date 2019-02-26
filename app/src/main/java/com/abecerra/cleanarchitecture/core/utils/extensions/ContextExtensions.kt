package com.abecerra.cleanarchitecture.core.utils.extensions

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.res.Resources
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.*
import android.widget.TextView
import android.widget.Toast
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

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.context, message, duration).show()
}

fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun enableFullScreen(window: Window) {
    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

fun inflate(@LayoutRes resourceLayout: Int, viewGroup: ViewGroup? = null, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(resourceLayout, viewGroup, attachToRoot)
}

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