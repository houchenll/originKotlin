package com.hc.kotlin.coroutine.basic

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doHelloWorld()

    // doHelloWorld()这个挂起函数执行完成后，才会执行到这里
    println("Done")
}

// coroutineScope 是一个builder，可创建自己的scope
// 只有自身launch的所有coroutine都完成后，scope也会完成
// coroutineScope 是一个挂起函数，不会阻塞线程的执行
// 可以在任何挂起函数中执行
// 内部可以发起且执行多个并发操作(协程)
suspend fun doHelloWorld() = coroutineScope {
    // ScopeCoroutine{Active}@33833882
    println(this)

    launch {
        // StandaloneCoroutine{Active}@512ddf17
        println(this)

        delay(1000L)
        println("World 1")
    }

    launch {
        // StandaloneCoroutine{Active}@512ddf17
        println(this)

        delay(2000L)
        println("World 2")
    }

    println("Hello")
}
