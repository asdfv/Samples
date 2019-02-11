package by.samples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.samples.broadcasting.NameBroadcastActivity
import by.samples.broadcasting.TimeTickBroadcastActivity
import by.samples.multithrading.AsyncTaskActivity
import by.samples.multithrading.CoroutinesActivity
import by.samples.multithrading.MultithreadingActivity
import by.samples.multithrading.RxActivity
import by.servicebroadcastapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        start_time_tick_activity_button.setOnClickListener {
            startActivityByType(TimeTickBroadcastActivity::class.java)
        }
        start_broadcast_name_activity_button.setOnClickListener {
            startActivityByType(NameBroadcastActivity::class.java)
        }
        start_multithreading_activity_button.setOnClickListener {
            startActivityByType(MultithreadingActivity::class.java)
        }
        start_async_task_activity_button.setOnClickListener {
            startActivityByType(AsyncTaskActivity::class.java)
        }
        start_rx_activity_button.setOnClickListener {
            startActivityByType(RxActivity::class.java)
        }
        start_coroutines_activity_button.setOnClickListener {
            startActivityByType(CoroutinesActivity::class.java)
        }
    }
}
