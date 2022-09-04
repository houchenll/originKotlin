package com.hc.kotlin.coroutine.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 协程是可暂停运算的一个实例
// 从概念上看它和线程类似，都是可以并行执行一段代码
// 但是，协程没有和任何特定线程绑定，它可能在一个线程挂起，却在另一个线程恢复执行
// 协程可以理解为轻量级线程，但有很多重要区别

// Structured concurrency 结构化并发
// 新协程只能在 CoroutineScope 中创建，它会划定创建的协程的生命周期的边界
// 实际项目中会创建很多协程，结构化并发保证它们不会丢失和泄露。
// 只有内部所有协程都结束时，外部的scope才会结束。
// 结构化并发也会保证代码中的所有错误都能被报告，永远不会丢失。？？？

// runBlocking is also a coroutine builder that bridges the non-coroutine world of a regular
// fun main() and the code with coroutines inside of runBlocking { ... } curly braces.
// The name of runBlocking means that the thread that runs it (in this case — the main thread)
// gets blocked for the duration of the call, until all the coroutines inside runBlocking { ... }
// complete their execution.
// You will often see runBlocking used like that at the very top-level of the application and
// quite rarely inside the real code, as threads are expensive resources and blocking them is
// inefficient and is often not desired.
// runBlocking 是一个普通函数，可不在协程中执行
// 不能在协程中调用本方法
// 被设计用来连接非协程世界和内部的协程
// 一般在main函数和测试函数中调用，用作测试，不能用在真实代码的线程中
fun main() = runBlocking {
    // BlockingCoroutine{Active}@123772c4
    println(this)

    // launch a new coroutine and continue
    // launch is a coroutine builder. It launches a new coroutine concurrently with the rest of the code,
    // which continues to work independently.
    // launch is declared only in the CoroutineScope, 只能在协程中调用
    launch {
        // StandaloneCoroutine{Active}@59f95c5d
        println(this)

        // delay is a special suspending function. It suspends the coroutine for a specific time.
        // Suspending a coroutine does not block the underlying thread, but allows other coroutines
        // to run and use the underlying thread for their code.
        delay(1000L)  // non-blocking delay for 1 second
        println("World")  // print after delay
    }

    println("Hello")  // main coroutine continues while a previous one is delayed
}
