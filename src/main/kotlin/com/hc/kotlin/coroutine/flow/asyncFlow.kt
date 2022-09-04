package com.hc.kotlin.coroutine.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

// kotlin flow: return multiple asynchronously computed values

fun simple(): List<Int> = listOf(1, 2, 3)

fun sequence(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(300)
        yield(i)
    }
}

suspend fun suspendFunction(): List<Int> {
    delay(1000)
    return listOf(1, 2, 3)
}

fun flowSimple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun flowCold(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun flowCancellation(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        println("Emitting $i")
        emit(i)
    }
}

fun main() {
//    simple().forEach { value -> println(value) }

//    sequence().forEach { value -> println(value) }

    runBlocking {
//        suspendFunction().forEach { value -> println(value) }

//        launch {
//            for (k in 1..3) {
//                println("I'm not blocked $k")
//                delay(100)
//            }
//        }
//        flowSimple().collect{ value -> println(value) }

//        println("Calling flow code function...")
//        val flowCold = flowCold()
//        println("Calling collect...")
//        flowCold.collect { value -> println(value) }
//        println("Calling collect again...")
//        flowCold.collect { value -> println(value) }

        withTimeoutOrNull(250) {
            flowCancellation().collect { value -> println(value) }
        }

        println("Done")
    }
}
