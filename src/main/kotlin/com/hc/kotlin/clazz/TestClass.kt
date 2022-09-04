package com.hc.kotlin.clazz

fun main() {
    // 1. 创建 class 对象，没有new关键字
//    val person = Person()

    // 2. 使用带参数构造函数创建类对象
//    val person = Person("liu", "lei")
//    println("${person.firstName} ${person.lastName}")

    val student = Person()
//    student.nickName = "Bill Gates"
//    println("nickName is ${student.nickName}")
    student.printInfo()

//    Animal.Companion.printInfo()
}
