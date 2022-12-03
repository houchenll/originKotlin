package com.hc.kotlin.json

import com.google.gson.Gson
import org.json.JSONObject

fun main() {
//    val text = "浙江同花顺基金\n销售有限公司"
//    val jump = "http://www.baidu.com"
//    JSONObject("")
//    val json = JSONObject().apply {
//        put("content", text)
//        put("url", jump)
//    }
//    println(json)
//    val jsonStr = json.toString()
//    println(jsonStr)
//    val temp = "this is $jsonStr"
//    println(temp)

    val source = "{\"param\": {\"name\": \"jack\", \"age\": 23.5}, \"key1\": \"123\"}"
    val config = Gson().fromJson(source, Config::class.java)
    println(config.key1)
    println(config.param)
    println(JSONObject(config.param).toString())
}

//class Config(var param: String = "", var key1: String = "")
class Config(var param: Map<String, String>, var key1: String = "")
