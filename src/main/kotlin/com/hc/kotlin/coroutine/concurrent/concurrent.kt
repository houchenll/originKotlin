package com.hc.kotlin.coroutine.concurrent

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun sequence() = runBlocking {
    doSomethingUsefulOne()
    doSomethingUsefulTwo()
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 29
}


// 默认顺序执行
fun sequentialByDefault() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")
}

// 使用 async 并行执行
fun concurrentByAsync1() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        // async 启动的两个协程已自动执行
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}


fun concurrentByAsync() = runBlocking {
    val one = async {
        doSomethingUsefulOne()
    }
    val two = async {
        doSomethingUsefulTwo()
    }
    // async 启动的两个协程已自动执行
    val answer = one.await() + two.await()
    println("The answer is $answer")
}


// 延迟启动的 async，需要手动启动
fun lazyStartAsync() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        // async 启动的两个协程需要手动启动
        one.start()
        two.start()
        // 如果不先手动启动，就是顺序执行
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

fun main() {
//    sequentialByDefault()
    concurrentByAsync()
    lazyStartAsync()
}
