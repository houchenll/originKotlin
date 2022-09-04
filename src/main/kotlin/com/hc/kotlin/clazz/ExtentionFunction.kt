package com.hc.kotlin.clazz

import java.util.UUID

class Entity3(val id: String, val name: String)

// Extension function
fun Entity3.printInfo() {
    println("Entity3 class with id $id, name $name")
}

// extension property
val Entity3.info: String
    get() = "info is id : $id, name $name"

fun main() {
    val entity = Entity3(UUID.randomUUID().toString(), "easy")
    entity.printInfo()
    println(entity.info)
}
