package com.hc.kotlin.str

fun main() {
    val stock = Stock("512760", "20")
    val item = Item("512760", "20")
    if (stock.code === item.code && stock.market === item.market) {
        println("equals")
    } else {
        println("not equals")
    }
}

class Stock(var code: String = "", var market: String = "")
class Item(var code: String = "", var market: String = "")
