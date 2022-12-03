package com.hc.kotlin.control

fun main() {
    val nums = listOf<Int>(1, 2, 3, 4, 5)

    // == 1
    var pos1 = if (nums[2] > 2) 1 else 0 + if (nums[3] > 2) 1 else 0 + if (nums[4] > 2) 1 else 0

    // == 2
    var pos2 = (if (nums[2] > 2) 1 else 0) + if (nums[3] > 2) 1 else 0 + if (nums[4] > 2) 1 else 0

    // == 3
    var pos3 = (if (nums[2] > 2) 1 else 0) + (if (nums[3] > 2) 1 else 0) + if (nums[4] > 2) 1 else 0

    // == 3 recommend
    var pos4 = (if (nums[2] > 2) 1 else 0) + (if (nums[3] > 2) 1 else 0) + (if (nums[4] > 2) 1 else 0)

    println(pos1)
    println(pos2)
    println(pos3)
    println(pos4)
}