package com.hc.kotlin.str

fun main() {
    var one = "http://www.baidu.com1"
    var two = "http://www.baidu.com"
    val result1 = one.equals(two)
    val result2 = one == two
    val result3 = one.compareTo(two)
    println(result1)
    println(result2)
    println(result3)
}