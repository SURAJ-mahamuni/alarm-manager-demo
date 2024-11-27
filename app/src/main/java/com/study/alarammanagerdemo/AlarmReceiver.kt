package com.study.alarammanagerdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra(Constants.EXTRA_MESSAGE)
        Log.e("Alarm manager message : ", message ?: "no message")
    }
}