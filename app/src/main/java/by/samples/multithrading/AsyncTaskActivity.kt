package by.samples.multithrading

import android.app.Activity
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import by.samples.showToast
import by.servicebroadcastapp.R
import kotlinx.android.synthetic.main.activity_async_task.*
import java.lang.ref.WeakReference

class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
        initViews()
    }

    private fun initViews() {
        start_button.setOnClickListener {
            startAsyncTask()
        }
    }

    private fun startAsyncTask() {
        MyAsyncTask(this).execute(5)
    }

    companion object {
        class MyAsyncTask(activity: AsyncTaskActivity) : AsyncTask<Int, Int, String>() {
            private val weakActivity = WeakReference(activity)

            override fun onPreExecute() {
                super.onPreExecute()
                val activity = weakActivity.get()
                if (activityFinishing(activity)) return
                activity?.async_task_progress_bar?.visibility = View.VISIBLE
            }

            override fun doInBackground(vararg params: Int?): String {
                val times = params.first() ?: 5
                repeat(times) {
                    Thread.sleep(1000)
                    publishProgress((it + 1) * 100 / times)
                }
                return "Progress complete"
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                val activity = weakActivity.get()
                if (activityFinishing(activity)) return
                activity?.async_task_progress_bar?.progress = values.first() ?: 10
            }

            override fun onPostExecute(result: String) {
                super.onPostExecute(result)
                val activity = weakActivity.get()
                if (activityFinishing(activity)) return
                activity?.showToast(result)
            }

            private fun activityFinishing(activity: Activity?) = activity == null || activity.isFinishing
        }
    }
}
