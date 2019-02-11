package by.samples.broadcasting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.servicebroadcastapp.R
import kotlinx.android.synthetic.main.activity_name_broadcast.*

class NameBroadcastActivity : AppCompatActivity() {
    companion object {
        const val NAME_ACTION = "by.samples.broadcasting.NAME_ACTION"
        const val NAME_KEY = "by.samples.broadcasting.NAME_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_broadcast)
        initViews()
    }

    private fun initViews() {
        send_broadcast_intent_button.setOnClickListener {
            val intent = Intent(NAME_ACTION)
            intent.putExtra(NAME_KEY, "Vasili")
            sendBroadcast(intent)
        }
    }
}
