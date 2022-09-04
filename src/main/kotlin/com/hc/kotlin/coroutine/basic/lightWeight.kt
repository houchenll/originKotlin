package com.hc.kotlin.coroutine.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 和线程相比，协程更轻量级，耗费资源更少
// 以下示例发起10万个协程并行执行，且耗费少量内存，如果换成线程，则会耗尽内存，OutOfMemoryError

fun main() = runBlocking {
    repeat(100_100) {
        launch {
            delay(5000L)
            print(".")
        }
    }
}