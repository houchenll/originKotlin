package com.hc.kotlin.clazz.classes

class Invoice

class Customer(val name: String)

fun main() {
    // 创建实例时，像调用普通方法一样调用构造函数
    val invoice = Invoice()
    val customer = Customer("Joe Smith")
}