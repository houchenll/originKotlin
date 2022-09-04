package com.hc.kotlin.coroutine.cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 当页面关闭时，页面内部创建的协程需要关闭
// launch 返回的 job 可用于关闭协程
// cancelAndJoin 是Job的扩展方法，等价于 cancel + join
fun main() = runBlocking {

    val job = launch {
        repeat(1000) {
            delay(500L)
        }
    }
    delay(1300L)
    job.cancel()
    job.join()
//    job.cancelAndJoin()

}
