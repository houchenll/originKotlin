package com.hc.kotlin.coroutine

import kotlinx.coroutines.*

// 模拟点击事件，执行一次请求
fun main() {
    // CoroutineScope 用于管理一组协程
    // 创建协程组的三种类型：IO, Main, Default
    // coroutineScope.launch 用协程组创建一个协程
    CoroutineScope(Dispatchers.IO).launch {
        fakeRequest1()
    }

    // 延缓程序结束
    Thread.sleep(2000)
}

// 执行一次请求
suspend fun fakeRequest1() {
    val result = getResult1FromApi()
    println("got request result 1 $result on ${Thread.currentThread()}")
    displayTextOnMain(result)
}

// 请求接口，返回一个数据，模拟IO耗时操作
suspend fun getResult1FromApi(): String {
    delay(1000)
    return "fake data 1 from api"
}

// 在主线程显示字符串
suspend fun displayTextOnMain(text: String) {
    // Dispatchers.Main 需要 kotlinx-coroutines-android 依赖包
    // 及 kotlinx-coroutines-test 依赖包
    withContext(Dispatchers.Main) {
        println("display $text on ${Thread.currentThread()}")
    }
}
