package com.thindie.common

import android.content.Context
import android.util.Log
import android.widget.Toast

private const val TAG = "SERVICE_TAG"
fun Any.WHATAHECK(message: () -> String = { TAG }) {
    Log.d(tag(), message.invoke())
}

fun Context.Toasty(throwable: Throwable) {
    Toast.makeText(this, throwable.tag(), Toast.LENGTH_SHORT).show()
}

fun Any.tag() = javaClass::class.simpleName ?: TAG