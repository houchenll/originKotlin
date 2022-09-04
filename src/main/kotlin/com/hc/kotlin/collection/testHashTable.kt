package com.hc.kotlin.collection

import java.util.Hashtable

/**
 * HashTable
 * 1. 构造函数中默认指定 capacity 为11，loadFactor 为0.75，创建长度为capacity的Entry数组，
 * Entry的key和value都为任意类型，使用capacity和loadFactor的乘积为 threshold
 *
 * 和HashMap区别
 * 1. 修改数据的函数添加了同步，是线程安全的，速度较慢
 * 2. 只有单链表，没有使用红黑树
 * 3. HashMap允许空key空value，HashTable不允许
 *
 * java 5以上时，使用ConcurrentHashMap替代HashTable
 *
 * https://juejin.cn/post/6844903925460500487
 */
fun main() {
    val table = Hashtable<Int, String>()

    // 方法
    // size(), contains(value), keys, entries, isEmpty, values, clear()
    // get(key), [key], getValue(key)
    // put(key, value)
    // forEach()

    table.put(1, "one")
    table[1] = "one"
}
