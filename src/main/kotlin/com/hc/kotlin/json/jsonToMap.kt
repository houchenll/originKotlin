package com.hc.kotlin.json

import org.json.JSONArray
import org.json.JSONObject

fun main() {
    val oneArray = JSONArray().put("recommend")
    val twoArray = JSONArray().put("sdfaf")
    val data = JSONObject().apply {
        put("one", oneArray)
        put("two", twoArray)
    }

    val map = data.toMap()
    map.forEach { entry ->
        println("${entry.key} - ${entry.value}")
    }
}