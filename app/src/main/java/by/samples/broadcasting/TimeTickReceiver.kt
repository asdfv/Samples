package by.servicebroadcastapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import by.samples.showToast
import java.text.SimpleDateFormat
import java.util.*

class TimeTickReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        dateFormat.timeZone = Calendar.getInstance().timeZone
        context.showToast(dateFormat.format(Date()))
    }
}
