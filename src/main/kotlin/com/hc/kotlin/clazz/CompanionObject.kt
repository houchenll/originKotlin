package com.hc.kotlin.clazz

// 类内部的对象声明用companion修饰，叫伴生对象，companion object
// companion object 一个类只能有一个，在类加载时初始化，对标于java的静态成员
// 因为在类加载时初始化，先于类对象创建，所以不能访问类的成员属性和方法
// 可以有别名，如果没有别名，默认名为 Companion
// 一般在该对象中添加静态属性或方法，构造单例

interface IdProvider {
    fun getId(): String
}

// 使用 private constructor 声明的主构造函数是私有的
class Entity private constructor(val id: String) {

    private val SEASON = "summer"

    fun printSeason() {
        // 实例成员方法可访问伴生对象的属性和方法
        println("season $SEASON, year $YEAR")
    }

    // companion object is an object scoped to an instance of another class
    // companion object 有权限访问所在类的私有成员和私有构造函数
    // companion object 可以实现接口
    companion object : IdProvider {
        // const val 属性类似于java中定义的静态常量
        const val YEAR = "2022"

        // 可修改变量
        var time = System.currentTimeMillis()

        // 私有的属性和方法只能在 object 所在文件内部使用
        private const val NUMBER = 11

        fun create() = Entity(getId())

        override fun getId(): String {
            return "12345"
        }

        fun printInfo() {
            // companion object 中不能访问外部类的成员属性
//            println("season $SEASON")
            // companion object 中不能访问外部类的成员方法
//            printSeason()
        }
    }

}

fun main() {
    // 调用
    // 在 kotlin 中调用 companion object 中的属性或方法时，可以直接调用，也可以通过Companion或别名调用
    // Companion和别名不能同时使用，有别名时用别名，无别名时默认为Companion
    // 当在java中调用companion object中的方法时，必须指定Companion或别名
    // 在java中调用companion object的属性时，不需要指定Companion或别名，直接调用
    val entity1 = Entity.Companion.create()
//    Entity.Factory.create()
    val entity = Entity.create()
    println(Entity.getId())
    println(Entity.YEAR)
}
