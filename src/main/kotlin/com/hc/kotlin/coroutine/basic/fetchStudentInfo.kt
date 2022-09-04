package com.hc.kotlin.coroutine.basic

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 使用协程，把异步回调重构为同步调用代码
 */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()

    val job = launch(Dispatchers.IO) {
//        val provinceId = getProvinceInfo()
//        val cityInfo = getCityInfo(provinceId)
//        val countyInfo = getCountyInfo(cityInfo)
//        println("county info is $countyInfo")
    }
//    job.join()



    // main exit, coast 3020 ms
    println("main exit, coast ${System.currentTimeMillis() - startTime} ms")
}


fun callbackWay() {
    getProvinceInfo { provinceInfo ->
        getCityInfo(provinceInfo) { cityInfo ->
            getCountyInfo(cityInfo) { countyInfo ->
                println("county info is $countyInfo")
            }
        }
    }
}


fun getProvinceInfo(callback: (String) -> Unit) {
    println("got province info")
    callback("province")
}

fun getCityInfo(provinceInfo: String, callback: (String) -> Unit) {
    println("got city info")
    callback("hang zhou")
}

fun getCountyInfo(cityInfo: String, callback: (String) -> Unit) {
    println("got county info")
    callback("yu hang")
}


//suspend fun getProvinceInfo(): String {
//    delay(1000L)
//    println("got province info")
//    return "zhe jiang"
//}
//
//suspend fun getCityInfo(provinceId: String): String {
//    delay(1000L)
//    println("got city info")
//    return "hang zhou"
//}
//
//suspend fun getCountyInfo(cityId: String): String {
//    delay(1000L)
//    println("got county info")
//    return "yu hang"
//}
