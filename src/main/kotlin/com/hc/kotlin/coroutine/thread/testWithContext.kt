package com.hc.kotlin.coroutine.thread

import kotlinx.coroutines.*

// withContext 是挂起函数
// 挂起函数会暂停(挂起)外层协程的执行
fun main() {
    log("main enter")

//    runBlocking {
//        log("runBlocking start ")
//        // 如果withContext外层是runBlocking，会暂停runBlocking的执行
//        withContext(Dispatchers.IO) {
//            log("with context start")
//            delay(1000L)
//            log("with context end")
//        }
//        log("runBlocking end")
//    }

    runBlocking {
        log("runBlocking start ")
        // launch 不是挂起函数，不会挂起外层协程的执行
        launch(Dispatchers.Default) {
            log("coroutine start ")
            withContext(Dispatchers.IO) {
                log("with context start")
                delay(1000L)
                log("with context end")
            }
            log("coroutine end")
        }
        log("runBlocking end")
    }

    log("main exit")
}

fun log(msg: String) {
    println("$msg : ${Thread.currentThread().name}")
}