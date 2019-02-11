package by.samples.multithrading

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.samples.emulateWork
import by.samples.showToast
import by.servicebroadcastapp.R
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CoroutinesActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        job = Job()
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    private fun initViews() {
        coroutines_start_button.setOnClickListener {
            startProcessAsync(3)
        }
    }

    private fun startProcessAsync(seconds: Int) = launch {
        doWorkInBackground(seconds).join()
        showToast("Complete")
    }

    private fun doWorkInBackground(seconds: Int) = launch(Dispatchers.Default) {
        repeat(seconds) {
            emulateWork(1)
        }
    }
}
