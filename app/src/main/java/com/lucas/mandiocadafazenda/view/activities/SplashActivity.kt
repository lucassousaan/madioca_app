package com.lucas.mandiocadafazenda.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.lucas.mandiocadafazenda.R

class SplashActivity : AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private val DELAY: Long = 1500

    private val mRunnable: Runnable = Runnable {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, DELAY)
    }

    public override fun onDestroy() {
        super.onDestroy()
        if (mDelayHandler != null)
            mDelayHandler!!.removeCallbacks(mRunnable)
    }
}
