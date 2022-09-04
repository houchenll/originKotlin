package com.hc.kotlin.func

// higher order functions are functions that either return another function
// or take function as parameter values.

// 类型1：接收函数作为参数
fun printFilteredStrings(list: List<String>, predict: ((String) -> Boolean)?) {
    list.forEach {
        if (predict?.invoke(it) == true) {
            println(it)
        }
    }
}

// 把函数赋值给变量
val predict: (String) -> Boolean = {
    it.startsWith("C")
}

// 返回函数
fun getPrintPredict(): (String) -> Boolean {
    // 把 lambda 表达式作为返回值
    return { it.startsWith("J") }
}

fun main() {
    val list = listOf("Kotlin", "Java", "Cpp", "Javascript", null)
    list
        .filterNotNull()
        .associateWith { it.length }
        .forEach { (key, value) ->
            println("key $key, value $value")
        }

    // 如果最后一个参数是函数，可以把lambda表达式放在函数外
//    printFilteredStrings(list) { it.startsWith("K") }
//    printFilteredStrings(list, getPrintPredict())
//    printFilteredStrings(list, predict)
//    printFilteredStrings(list, null)

    val fruits = listOf("apple", "orange", "banana", "pink", null)
    fruits
        .filterNotNull()
        .take(4)    // 取前3个元素
        .takeLast(4)    // 取后2个元素
        .filter {
            it.startsWith("a")
        }
        .map {
            it.length
        }
        .forEach {
            println(it)
        }
}
