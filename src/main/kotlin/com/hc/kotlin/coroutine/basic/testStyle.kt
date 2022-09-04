package com.hc.kotlin.coroutine.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val textView = TextView()

    normalWay(textView)
    coroutineWay(textView)
}



fun normalWay(textView: TextView) {
    fetchUserData { user ->  // callback
        textView.text = user.name
    }
}

fun fetchUserData(callback: (user: User) -> Unit) {
    // get User from url ...
    Thread.sleep(1000L)
    callback(User())
}




suspend fun coroutineWay(textView: TextView) {
    textView.text = fetUserInfo().name
}

suspend fun fetUserInfo(): User {
    // get User from url ...
    delay(1000L)
    return User()
}








class User(val name: String = "")

interface Callback {

}

class TextView(var text: String = "")
