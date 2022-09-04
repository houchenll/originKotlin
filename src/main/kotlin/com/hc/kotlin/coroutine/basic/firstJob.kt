package com.hc.kotlin.coroutine.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        delay(1000L)
        println("World")
    }
    println("Hello")
    job.join()  // wait until job coroutine complete
    println("Done")
}
