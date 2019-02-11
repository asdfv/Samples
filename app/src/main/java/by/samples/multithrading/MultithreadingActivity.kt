package by.samples.multithrading

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import by.samples.emulateWork
import by.samples.showToast
import by.servicebroadcastapp.R
import kotlinx.android.synthetic.main.activity_multithreading.*
import kotlin.concurrent.thread

class MultithreadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multithreading)
        initViews()
    }

    private fun initViews() {
        start_in_ui_button.setOnClickListener {
            processInUI(3)
        }
        start_in_background_method_button.setOnClickListener {
            processInBackgroundWithMethod(3)
        }
        start_in_background_handler_button.setOnClickListener {
            processInBackgroundWithHandler(3)
        }
    }

    private fun processInBackgroundWithMethod(seconds: Long) {
        showToast("Process starting")
        thread {
            repeat(seconds.toInt()) {
                emulateWork(1)
                runOnUiThread { showToast("${it + 1}") }
            }
        }
    }

    private fun processInBackgroundWithHandler(seconds: Long) {
        showToast("Process starting")
        val handler = Handler(Looper.getMainLooper())
        thread {
            repeat(seconds.toInt()) {
                emulateWork(1)
                handler.post { showToast("${it + 1}") }
            }
        }
    }

    private fun processInUI(seconds: Long) {
        showToast("Process starting")
        emulateWork(seconds)
        showToast("Process complete")
    }
}
