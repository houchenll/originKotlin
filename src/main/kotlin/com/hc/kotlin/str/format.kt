package com.hc.kotlin.str

object Contant {
    const val RESPONSE = "hello_%s"
}

class Demo {
    companion object {
        const val ACTION = "shouye_new%d"
    }

    fun format(): String {
        val value = String.format(ACTION, 1)
        println(value)
        return value
    }
}

fun main() {
//    val message = String.format(Contant.RESPONSE, "jack")
    // hello_jack
//    println(message)

    Demo().format()
}
