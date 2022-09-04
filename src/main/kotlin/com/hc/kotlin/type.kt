package com.hc.kotlin

fun main() {
    // 整数之间除法仍是整数，丢弃整数部分
    val x = 5 / 2
    println(x)  // 2
    println(x == 2)  // true

    // 类型转换
    val y = 2.toDouble()
    println(y)  // 2.0

    testArray()

    // 字符串
//    testString()
}

fun testArray() {
    // 使用库函数 arrayOf 创建数组
    val array1 = arrayOf(1, 2, 3)
    array1.forEach { println(it) }

    // 使用Array创建并初始化数组
    val asc = Array(5) {i -> (i * i ).toString()}
    asc.forEach { println(it) }
}

fun testString() {
    val str = "abc"
    for (c in str) {
        println(c)
    }

    val s = "abc" + 1
    println(s + "def")

    // 转义字符串
    val s1 = "Hello, world!\n"
    println(s1)
    // 原始字符串
    val text = """
        for (c in "foo")
            print(c)
    """.trimIndent()
    println(text)
    // trimMargin()函数去除前导空格，|用作边界前缀
    val text2 = """
        |Tell me and I forget.
          |Teach me and I remember.
             |Involve me and I learn.
                  |(Benjamin Franklin)
    """.trimMargin()
    println(text2)
    val i = 10
    println("i = $i")  // i = 10
    println("$s.length is ${s.length}")  // abc1.length is 4
}
