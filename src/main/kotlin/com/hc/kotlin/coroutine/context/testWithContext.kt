package com.hc.kotlin.coroutine.context

import kotlinx.coroutines.*

fun main() = runBlocking {
    val textView = TextView()


    val job = launch(Dispatchers.IO) {
        val userName = getUserInfo()
        withContext(Dispatchers.Main) {
            textView.name = userName
        }
    }

}

suspend fun getUserInfo(): String {
    delay(1000L)
    return "jack"
}

class TextView(var name: String = "")
