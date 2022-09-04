package com.hc.kotlin

import javax.xml.bind.DatatypeConverter.parseInt

// 控制流：if, when, for, while

fun main() {
//    testIf()
//    testWhen()
    testWhenNull()
}

var greeting: String? = null

fun testIf() {
    val a = 2
    val b = 3

    // 传统用法1
    var max1 = a
    if (a < b) max1 = b
    println(max1)

    // 传统用法2
    greeting = "Morning"
    if (greeting != null) {
        println(greeting)
    } else {
        println("Hi")
    }

    // 作为表达式1
    val max2 = if (a > b) a else b
    println(max2)

    // 作为表达式2
    // if 的分支可以是代码块，最后的表达式作为该块的值
    val max3 = if (a > b) {
        println("choose a")
        a
    } else {
        println("choose b")
        b
    }
    println(max3)

    // 作为表达式3
    val greetingToPrint = if (greeting != null) greeting else "Hi"
    println(greetingToPrint)
}

fun testWhen() {
    val x = 31
    val y = 3
    val s = "5"
    val validNumbers = arrayOf(31, 32, 33)

    // when 用法1：替换 switch
    // when 表达式取代了类 C 语言的 switch 语句
    // x可以是数字、字符串
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        3, 4 -> println("x == 3 or x == 4")
        parseInt(s) -> println("s encodes x")
        in 10..20 -> println("x is in teen range")  // 包括10和20
        in validNumbers -> println("x is valid")
        else -> println("otherwise")
    }

    // when 用法2：作为表达式
    // 'when' expression must be exhaustive, add necessary 'else' branch
    // exhaustive: 详尽无遗
    val greetingToPrint = when (greeting) {
        null -> "Hi"
        else -> greeting
    }

    // when 用法3：判断类型
    println(hasPrefix(x))
}

fun testWhenNull() {
    val str = null
    when(str) {
        "GET" -> println("GET")
        "POST" -> println("POST")
        else -> println("DEFAULT")
    }
}

fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}
