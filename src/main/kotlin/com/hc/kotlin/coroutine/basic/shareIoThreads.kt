package com.hc.kotlin.coroutine.basic

import kotlinx.coroutines.*

/**
 * 同时启动多个运行在 IO 线程池上的协程，并发执行，每个协程执行 1000ms
 * 打印他们的线程，查看执行时间和线程复用情况
 * 启动 100 个协程，共耗时 1026ms，使用 8 个IO线程，平均1个线程1秒执行 12 个协程
 * 启动 1千 个协程，共耗时 1064ms，使用 29 个IO线程，平均1个线程1秒执行 32 个协程
 * 启动 1万 个协程，共耗时 1234ms，使用 47 个IO线程，平均1个线程1秒执行 172 个协程
 * 启动 10万 个协程，共耗时 2856ms，使用 127 个IO线程，平均1个线程1秒执行 275 个协程
 * 启动 100万 个协程，共耗时 12047ms，使用 120 个IO线程，平均1个线程1秒执行 692 个协程
 */


fun main() = runBlocking {

    repeat(10 * 1000) {
        launch(Dispatchers.IO) {
            delay(1000)
        }
    }

}
