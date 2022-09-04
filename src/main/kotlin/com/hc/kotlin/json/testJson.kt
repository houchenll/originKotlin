package com.hc.kotlin.json

import org.json.JSONObject

fun main() {
    val text = "浙江同花顺基金\n销售有限公司"
    val jump = "http://www.baidu.com"
    val json = JSONObject().apply {
        put("content", text)
        put("url", jump)
    }
    println(json)
    val jsonStr = json.toString()
    println(jsonStr)
    val temp = "this is $jsonStr"
    println(temp)
}