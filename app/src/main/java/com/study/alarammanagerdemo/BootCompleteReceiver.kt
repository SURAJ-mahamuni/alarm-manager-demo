package com.study.alarammanagerdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BootCompleteReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.e("boot_up", "your device is ready to use.")
            Toast.makeText(context, "your device is ready to use.", Toast.LENGTH_LONG).show()
        }
    }
}