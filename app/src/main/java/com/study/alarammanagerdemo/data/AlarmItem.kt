package com.study.alarammanagerdemo.data

import java.time.LocalDateTime

data class AlarmItem(var time: String? = "", var message: String? = "") {
    fun getLocalTime(): LocalDateTime {
        return LocalDateTime.now().plusSeconds(time?.toLong() ?: 0)
    }
}
