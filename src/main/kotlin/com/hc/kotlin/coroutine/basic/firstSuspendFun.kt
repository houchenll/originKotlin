package com.hc.kotlin.coroutine.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { doWorld() }
    println("Hello")
}

// 挂起函数可以像普通函数一样在协程中调用
// 它们可以调用其它挂起函数，并挂起调用自身的协程的执行
// 挂起函数可以在协程或挂起函数中执行
suspend fun doWorld() {
    delay(1000L)
    println("World")
}
