package com.hc.kotlin.clazz

import com.hc.kotlin.enums.BeanType
import com.hc.kotlin.enums.BeanType.*
import java.util.UUID

// 对象声明
// object declarations is convenient way of creating threads saved singletons within kotlin
object BeanFactory {
//    fun create() = Bean("id", "name")

    fun create(type: BeanType): Bean {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EASY -> type.name
            MEDIUM -> type.getFormattedName()
            HARD -> "hard"
            else -> "else"
        }
        return Bean(id, name)
    }
}

class Bean(private val id: String, private val name: String) {
    override fun toString(): String {
        return "id: $id, name: $name"
    }
}

fun main() {
    val bean = BeanFactory.create(EASY)
    println(bean)   // com.hc.kotlin.clazz.Bean@4dc63996
    val bean2 = BeanFactory.create(MEDIUM)
    println(bean2)  // com.hc.kotlin.clazz.Bean@d716361
}
