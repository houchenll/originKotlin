package com.hc.kotlin.standard

import org.json.JSONObject

fun main() {
    val data = DataBean()
    val json = data.toJson()
    println(json)
}

class DataBean(val name: String = "jack", val age: Int = 23) {
    fun toJson() = JSONObject().run {
        put("name", name)
        put("age", age)
    }.toString()
}
