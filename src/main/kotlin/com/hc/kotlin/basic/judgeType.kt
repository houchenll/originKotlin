package com.hc.kotlin.basic

open class People

class Student : People()

fun main() {
    val jack = null
    // null is Xxx return false，不会崩溃异常
    if (jack is People) {
        println("$jack")
    } else {
        println("not")
    }
}