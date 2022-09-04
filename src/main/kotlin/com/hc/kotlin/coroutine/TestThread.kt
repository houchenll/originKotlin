package com.hc.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
//    singleThread()
//    multiThread()
//    runOnSingleVariable()

    coroutineMultiThread()
    Thread.sleep(2000L)
}

fun singleThread() {
    val thread = Thread {
        println("${Thread.currentThread()} has run")
    }
    thread.start()
}

fun multiThread() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    repeat(3) {
        Thread {
            println("${Thread.currentThread()} has started")
            for (i in states) {
                println("${Thread.currentThread()} - $i")
                Thread.sleep(50)
            }
        }.start()
    }
}

fun coroutineMultiThread() {
    repeat(3) {
        GlobalScope.launch {
            println("Hi from ${Thread.currentThread()}")
        }
    }
}

// 竞态问题，结果难以预料
fun runOnSingleVariable() {
    var count = 0
    for (i in 1..50) {
        Thread {
            count += 1
            println("Thread: $i count: $count")
        }.start()
    }
}
