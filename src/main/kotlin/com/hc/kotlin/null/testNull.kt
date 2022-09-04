package com.hc.kotlin.`null`

fun main() {
    val config = getConfig(1)
    printInfo(config?.method, config?.param)
}

fun printInfo(method: String?, param: String?) {
    println("info method is $method, param is $param")
}

fun getConfig(type: Int): Config? {
    return if (type == 0) {
        Config()
    } else {
        null
    }
}

class Config(var method: String = "post", var param: String = "param")