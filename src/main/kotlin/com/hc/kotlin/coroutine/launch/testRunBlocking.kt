package com.hc.kotlin.coroutine.launch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println("main start")

    runBlocking {
        println("blocking start")
        launch {
            repeat(3) {
                delay(100L)
                println("coroutine A $it")
            }
        }
        // GlobalScope 启动的协程和 runBlocking 启动的协程没有共享同一个context
        // 所以 runBlocking 不会等待 GlobalScope启动的协程结束
        GlobalScope.launch {
            repeat(3) {
                delay(120L)
                println("coroutine B $it")
            }
        }
        println("blocking end")
    }

    println("main exit")
}