package com.hc.kotlin.generic

// 泛型接口
interface Drinks<T> {
    fun taste(): T
    fun price(t: T)
}

// 泛型类
abstract class Color<T>(open var t: T) {
    abstract fun printColor()
}

class Blue {
    val color = "blue"
}

class BlueColor(override var t: Blue): Color<Blue>(t) {
    override fun printColor() {
        println("color ${t.color}")
    }
}

class IntArrayUtil(private val array: Array<Int>) {

    fun findElement(element: Int, foundElement: (index: Int, element: Int?) -> Unit) {
        for (i in array.indices) {
            if (array[i] == element) {
                foundElement(i, element)
                return
            }
        }

        foundElement(-1, null)
    }

}

class CommonArrayUtil<T>(private val array: Array<T>) {

    fun findElement(element: T, foundElement: (index: Int, element: T?) -> Unit) {
        for (i in array.indices) {
            if (array[i] == element) {
                foundElement(i, element)
                return
            }
        }

        foundElement(-1, null)
    }

}

fun<T> findElement(array: Array<T>, element: T, foundElement: (index: Int, element: T?) -> Unit) {
    for (i in array.indices) {
        if (array[i] == element) {
            foundElement(i, element)
            return
        }
    }

    foundElement(-1, null)
}

fun<T, R> printPersonInfo(name: T, age: R) {
    println("name is $name, age is $age")
}

fun main() {
    val intArrayUtil = IntArrayUtil(arrayOf(1, 2, 3, 4, 5))
    intArrayUtil.findElement(3) { index, element ->
        println("found index $index, element $element")
    }

    val commonArrayUtil1 = CommonArrayUtil<Int>(arrayOf(1, 2, 3, 4, 5))
    commonArrayUtil1.findElement(4) { index, element ->
        println("found index $index, element $element")
    }

    val commonArrayUtil2 = CommonArrayUtil<String>(arrayOf("1", "2", "3", "4", "5"))
    commonArrayUtil2.findElement("2") { index, element ->
        println("found index $index, element $element")
    }

    // 泛型类型可推断
    findElement(arrayOf(1, 2, 3, 4, 5), 3) { index, element ->
        println("found index $index, element $element")
    }

    // 两个泛型时，泛型类型也可推断
    printPersonInfo("jack", 23)

    BlueColor(Blue()).printColor()
}
