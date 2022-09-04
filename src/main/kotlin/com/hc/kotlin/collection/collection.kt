package com.hc.kotlin.collection

// array, list, set, map
fun main() {
//    testArray()
//    testList()
    testMap()
}

fun testArray() {
    // arrayOf 定义数组，返回类型为 Array
    val interestingThings = arrayOf("kotlin", "java", "cpp")
    println(interestingThings)
    println("size ${interestingThings.size}")
    // 优先使用索引，索引 > get
    println("first element is ${interestingThings[0]}")
    println("first element is ${interestingThings.get(0)}")
    // 遍历数组中所有元素 1
    for (thing in interestingThings) {
        println(thing)
    }
    // 遍历数组中所有元素 2
    // forEach 后面的 lambda {} 是传递给 forEach的函数的函数体
    // lambda对应action函数的入参名默认为it
    interestingThings.forEach {
        println(it)
    }
    // 修改lambda函数入参名
    interestingThings.forEach { thing ->
        println(thing)
    }
    // lambda：如果一个函数的唯一参数是另一个函数，可以省略两个函数的()
    // 带index的遍历
    interestingThings.forEachIndexed { index, thing ->
        println("index $index, value $thing")
    }
}

fun testList() {
    // listOf 定义只读列表，返回 List
    val interestingThings = listOf("Kotlin", "Java", "Cpp")
    // 通过索引和get检索，索引优先于get
    println("first element is ${interestingThings[0]}")
    println("first element is ${interestingThings.get(0)}")
    // 无索引遍历
    interestingThings.forEach { thing ->
        println(thing)
    }
    // 带索引遍历
    interestingThings.forEachIndexed { index, thing ->
        println("$thing at index $index")
    }

    // 定义可变列表，返回 MutableList
    val fruits = mutableListOf("banana", "apple", "orange")
    fruits.add("pear")
    // 设置，索引优先于 set
    fruits[2] = "lemon"
    fruits.set(2, "lemon")
    // 检索，索引优先于 get
    println(fruits[2])
    println(fruits.get(2))
}

fun testMap() {
    // 返回只读map，LinkedHashMap，返回Map类型，key类型可以不一致
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { (key, value) -> println("$key -> $value") }

    // 定义可变map，返回 MutableMap，key类型可以不一致
    val students = mutableMapOf(1 to "a", 2 to "b", "c" to 3)
    // 向map添加数据，索引优先于put
    students.put(4, "d")
    students[4] = "d"
    // 修改数据
    students.put(2, "bb")
    students[2] = "bb"
    students.forEach { (key, value) -> println("$key -> $value") }
}
