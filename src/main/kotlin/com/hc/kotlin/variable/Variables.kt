package com.hc.kotlin.variable

// top level 变量
// 文件内所有地方可访问
val country: String = "CN"

fun main() {
    // val 不可修改变量
    // 标准写法
    val name: String = "Jack"
    // 推断类型
    val name1 = "Jack"
    // 稍后赋值
    val name2: String
    name2 = "Jack"

    // var 可修改变量
    // 标准实现
    var age: Int = 18
    age = 24
    // 推断类型
    var age1 = 18
    // 稍后赋值
    var age2: Int
    age2 = 24

    // 可空变量
    // 在类型后添加?表示变量可能为空
    // 此时必须声明类型，否则编译器不知道是这种类型的空
    val name3: String? = null
}
