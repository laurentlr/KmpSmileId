package com.sample

import cocoapods.SmileID.SmileIDVersionString
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual fun SmileIdInit() {
    SmileIDVersionString
}