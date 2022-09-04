package com.hc.kotlin.coroutine.basic

import kotlin.concurrent.thread

// Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
fun main() = repeat(100_100) {
    thread {
        Thread.sleep(5000L)
        print(".")
    }
}