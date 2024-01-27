package com.sample

import android.content.Context
import com.smileidentity.SmileID

actual fun SmileIdInit() {
    lateinit var context: Context
    SmileID.initialize(context)
}