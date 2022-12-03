package com.hc.kotlin.list

fun main() {
    val nums = listOf<Int>(1, 2, 3)
    println(nums)

    nums.forEach { item ->
        println(item)
    }
}

