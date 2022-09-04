package com.hc.kotlin.basic

fun main() {
    val person: Person? = getPerson()
    println("start print person info")
    // person 为空，只会影响本句不被执行，后续语句依然会被执行
    person?.printInfo()
    println("main end")
}

fun getPerson(): Person? {
    return null
}

class Person(var name: String = "jack") {
    fun printInfo() {
        println("name is $name")
    }
}