package com.hc.kotlin.coroutine.context

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {


    val request = launch {
        repeat(3) { i ->
            launch  {
                delay((i + 1) * 200L)
                println("Coroutine $i is done")
            }
        }
        println("request: I'm done")
    }
    request.join()
    println("request is complete")

}