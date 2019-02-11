package by.samples.broadcasting

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import by.samples.showToast

class NameReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val name = intent.getStringExtra(NameBroadcastActivity.NAME_KEY)
        context.showToast("Message received: $name")
    }
}
