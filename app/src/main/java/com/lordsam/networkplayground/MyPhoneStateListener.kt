package com.lordsam.networkplayground

import android.app.Activity
import android.telephony.PhoneStateListener
import android.telephony.SignalStrength
import android.util.Log
import android.widget.TextView


class MyPhoneStateListener(private val ctx :MainActivity) : PhoneStateListener() {

    private var signalStrengthValue = 0

    override fun onSignalStrengthsChanged(signalStrength: SignalStrength){
        super.onSignalStrengthsChanged(signalStrength)
        signalStrengthValue = if (signalStrength.isGsm) {
            if (signalStrength.gsmSignalStrength != 99) signalStrength.gsmSignalStrength * 2 - 113 else signalStrength.gsmSignalStrength
        } else {
            signalStrength.cdmaDbm
        }
        Log.i("strength", signalStrengthValue.toString())
        ctx.findViewById<TextView>(R.id.tvSS).text = "Signal Strength :$signalStrengthValue"
    }
}