package com.hc.kotlin.queue

import java.util.concurrent.LinkedBlockingQueue

fun main() {
    val queue = FixInfinityQueue.create<String>(3)
    repeat(10) {
        queue.add(it.toString())
        println("current ${queue.join()}")
    }
}

/**
 * 长度固定，可无限添加的队列
 * 当列队满时，先移除队列头部再在尾部添加
 * 使用LinkedBlockingQueue实现，保证时间复杂度为O(1)，且不增长空间
 */
class FixInfinityQueue<E> private constructor(private val maxSize: Int) {
    private val delegate: LinkedBlockingQueue<E> = LinkedBlockingQueue(maxSize)

    companion object {
        fun <E> create(maxSize: Int): FixInfinityQueue<E> = FixInfinityQueue(maxSize)
    }

    fun off(e: E) = add(e)

    fun add(e: E): Boolean {
        println("add $e")
        if (0 == maxSize) {
            return false
        }
        while (maxSize <= size()) {
            println("full, poll")
            delegate.poll()
        }
        return delegate.add(e)
    }

    fun size(): Int = delegate.size

    fun join() = join(";")

    fun join(divider: String): String {
        val buffer = StringBuilder()
        delegate.forEach {
            buffer.append(it).append(divider)
        }
        return buffer.toString()
    }
}
