package by.samples.multithrading

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.samples.emulateWork
import by.samples.showToast
import by.servicebroadcastapp.R
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_rx.*

class RxActivity : AppCompatActivity() {
    private val TAG = "AppCompatActivity"
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)
        initViews()
    }

    private fun initViews() {
        rx_start_button.setOnClickListener {
            runRxInBackground(3)
        }
    }

    private fun runRxInBackground(seconds: Long) {
        val observer = object : DisposableCompletableObserver() {
            override fun onComplete() {
                showToast("Complete")
                Log.d(TAG, "Complete")
            }

            override fun onError(e: Throwable) {
                showToast(e.localizedMessage)
                Log.e(TAG, e.localizedMessage)
            }
        }

        disposable = Completable.fromAction { emulateWork(seconds) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
