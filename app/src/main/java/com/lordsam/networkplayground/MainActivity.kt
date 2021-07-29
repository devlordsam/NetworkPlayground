package com.lordsam.networkplayground

import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var telephonyManager: TelephonyManager? = null
    var psListener: MyPhoneStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        psListener = MyPhoneStateListener(this)
        telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        telephonyManager!!.listen(psListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS)
    }
}