package com.hc.kotlin.coroutine.context

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val request = launch {
        launch(Job()) {
            delay(1000)
        }

        launch {
            delay(1000)
        }
    }
    delay(500)
    request.cancel()

}
