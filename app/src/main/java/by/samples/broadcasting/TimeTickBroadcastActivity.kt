package by.samples.broadcasting

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.samples.showToast
import by.servicebroadcastapp.R
import by.servicebroadcastapp.TimeTickReceiver
import kotlinx.android.synthetic.main.activity_time_tick_broadcast.*

class TimeTickBroadcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_tick_broadcast)
        initViews()
    }

    private fun initViews() {
        val timeReceiver = TimeTickReceiver()
        register_button.setOnClickListener {
            registerReceiver(timeReceiver, IntentFilter("android.intent.action.TIME_TICK"))
            showToast("Registered")
        }
        unregister_button.setOnClickListener {
            unregisterReceiver(timeReceiver)
            showToast("UnRegistered")
        }
    }
}
