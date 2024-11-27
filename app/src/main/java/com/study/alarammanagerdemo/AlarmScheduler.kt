package com.study.alarammanagerdemo

import com.study.alarammanagerdemo.data.AlarmItem

interface AlarmScheduler {
    fun schedule(item: AlarmItem)
    fun cancel(item: AlarmItem)
}