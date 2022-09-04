package com.hc.kotlin.coroutine.cancellation

import kotlinx.coroutines.*

// 有两种方法可以取消 computation 代码的执行
// 一种是periodically调用挂起函数，来检查是否可取消，推荐使用 yield()
// 另一种是明确地检查取消状态 isActive
fun main() = runBlocking {

    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) {
            if (System.currentTimeMillis() > nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: quit!")

}
