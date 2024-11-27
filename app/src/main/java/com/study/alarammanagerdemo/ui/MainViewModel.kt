package com.study.alarammanagerdemo.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.alarammanagerdemo.AndroidAlarmScheduler
import com.study.alarammanagerdemo.AppEvent
import com.study.alarammanagerdemo.data.AlarmItem
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(@ApplicationContext val context: Context) : ViewModel() {

    private var androidAlarmScheduler : AndroidAlarmScheduler = AndroidAlarmScheduler(context)

    var _appEvent: MutableLiveData<AppEvent> = MutableLiveData()

    val appEvent: LiveData<AppEvent> get() = _appEvent

    val alarmData = MutableLiveData<AlarmItem>(AlarmItem())

    var btnName = MutableLiveData<String>("Schedule")

    var scheduleOrCancelState = false

    fun scheduleOrCancel() {
        if (scheduleOrCancelState) {
            //cancel
            scheduleOrCancelState = false
            androidAlarmScheduler.cancel(alarmData.value ?: AlarmItem())
            Log.e("alarm","cancel alarm ${alarmData.value}")
            btnName.postValue("Schedule")
        } else {
            //start
            scheduleOrCancelState = true
            androidAlarmScheduler.schedule(alarmData.value ?: AlarmItem())
            Log.e("alarm","start alarm ${alarmData.value}")
            btnName.postValue("Cancel")
        }
    }
}