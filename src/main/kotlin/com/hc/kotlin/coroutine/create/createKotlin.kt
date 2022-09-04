package com.hc.kotlin.coroutine.create

import kotlinx.coroutines.*

fun main() = runBlocking {

    val job1 = launch {
        delay(1000L)
    }
    val job2 = launch(Dispatchers.Default) {
        delay(1000L)
    }
    job2.join()
    val job3 = launch(Dispatchers.IO) {
        delay(1000L)
    }

}

suspend fun getUserName(): String {
    delay(1000)
    return "jack"
}
