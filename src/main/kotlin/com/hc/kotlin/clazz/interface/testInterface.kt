package com.hc.kotlin.clazz.`interface`

// 子类实现接口属性测试
interface PersonInter {
    fun name(): String
    fun age(): Int
    fun isFund(): Boolean = false
}

data class Student(val name: String, val age: Int) : PersonInter {
    override fun name(): String {
        return name
    }

    override fun age(): Int {
        return age
    }

    override fun isFund(): Boolean {
        return true
    }
}

data class Teacher(val stockName: String, val stockAge: Int) : PersonInter {
    override fun name(): String {
        return stockName
    }

    override fun age(): Int {
        return stockAge
    }
}

fun main() {
    val student = Student("jack", 23)
    println(student.getsAge())
    println(student.getsName())
}
