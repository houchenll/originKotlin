package com.hc.kotlin.coroutine.scope

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

// start
// end
// A
// exit
fun main() {
    println("start")

    GlobalScope.launch {
        launch {
            delay(100L)
            println("A")
        }
        launch {
            delay(300L)
            println("B")
        }
    }
    println("end")
    MainScope()

    Thread.sleep(200L)
    println("exit")
}



public interface CoroutineScope {
    public val coroutineContext: CoroutineContext
}


