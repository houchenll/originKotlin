package com.hc.kotlin.coroutine.context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

// context and dispatchers
// context elements: job, dispatcher
// coroutine include a dispatcher, which determine which thread or threads the coroutine executed in
// dispatcher can confine a coroutine executed in a specific thread, a thread pool, or unconfined

// all coroutine builders like launch or async can accept an optional CoroutineContext
fun main(): Unit = runBlocking {
    println(this)  // BlockingCoroutine{Active}@123772c4


    launch {
        // main
    }
    launch(Dispatchers.Main) {
        // main
    }
    launch(Dispatchers.IO) {
        // DefaultDispatcher-worker-1
    }
    launch(Dispatchers.Default) {
        // DefaultDispatcher-worker-3
    }
    launch(newSingleThreadContext("MyOwnThread")) {
        // MyOwnThread
    }


}
