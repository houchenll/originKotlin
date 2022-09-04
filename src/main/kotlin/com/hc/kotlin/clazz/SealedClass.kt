package com.hc.kotlin.clazz

import com.hc.kotlin.enums.BeanType
import com.hc.kotlin.enums.BeanType.*
import java.util.UUID

object Entity1Factory {
    fun create(type: BeanType): Entity1 {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EASY -> type.name
            MEDIUM -> type.getFormattedName()
            HARD -> type.name
            HELP -> type.name
        }
        return when (type) {
            EASY -> Entity1.Easy(id, name)
            MEDIUM -> Entity1.Medium(id, name)
            HARD -> Entity1.Hard(id, name, 0.5f)
            HELP -> Entity1.Help
        }
    }
}

sealed class Entity1() {
    object Help : Entity1() {
        val name = "Help"
    }

    data class Easy(val id: String, val name: String) : Entity1()
    data class Medium(val id: String, val name: String) : Entity1()
    data class Hard(val id: String, val name: String, val multiplier: Float) : Entity1()
}

fun main() {
    val msg = when (Entity1Factory.create(MEDIUM)) {
        is Entity1.Easy -> "easy class"
        is Entity1.Hard -> "hard class"
        Entity1.Help -> "help class"
        is Entity1.Medium -> "medium class"
    }
    println(msg)

    // data class
    // 只有属性都相同，两个对象就相同
    val entity1 = Entity1.Easy("id", "name")
    val entity2 = Entity1.Easy("id", "name")  // entity2 == entity1
    val entity3 = entity1.copy()  // entity3 == entity1
    if (entity1 == entity2) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    // entity1 !== entity2 !== entity3
}
