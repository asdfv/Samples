package by.samples

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Activity.startActivityByType(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
}

fun emulateWork(seconds: Long) {
    Log.d("emulateWork", "Start work in Thread: ${getThreadName()}")
    Thread.sleep(seconds * 1000)
}

fun getThreadName(): String = Thread.currentThread().name
