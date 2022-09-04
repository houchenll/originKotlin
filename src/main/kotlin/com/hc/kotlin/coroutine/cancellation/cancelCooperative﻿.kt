package com.hc.kotlin.coroutine.cancellation

import kotlinx.coroutines.*

// 协程取消操作需要协程配合
// 只有当协程内部有挂起函数时，协程才可以取消
// kotlinx.coroutines 包下的所有挂起函数都支持取消，他们执行过程中会检查协程是否已被取消
// 如果协程内部都是计算代码，没有检查协程是否可取消，这个协程就不能被取消
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            if (System.currentTimeMillis() > nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
        println("job: complete")
    }
    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancelAndJoin()
    println("main: exit")
}