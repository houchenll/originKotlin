package com.hc.kotlin.clazz

import com.hc.kotlin.interfaze.PersonInfoProvider

open class Cat(val name: String)

interface Behavior {
    fun bake()
}

// 对象表达式
// 意义：
// 1. 对象表达式可以越过类的定义，直接得到一个对象
// 用途：
// 1. 生成一个匿名内部类的对象，作为方法的参数。
// 实现：
// 1. object : AClass(), BInterface, CInterface
// 对象可继承0到1个超类，实现0到N个接口。如果超类有构造函数，必须传参给它。超类和接口的数量可以为0，见2
// 2. object {}
// 直接添加属性和方法
// 3. 对象表达式中可以访问作用域中的其他变量
fun main() {
    // 1. 生成 object express
    // 生成匿名对象
    // 在点击事件时有用，可作为点击事件的参数
    val provider = object : PersonInfoProvider, Cat("katty"), Behavior {
        // 为接口中定义的属性赋值
        override val providerInfo: String
            get() = "new info provider"

        // 可以在匿名内部类中添加新方法
        fun getToken() = "token"

        // 可以在匿名内部类中添加新参数
        val age = 100

        override fun bake() {
            println("$name is bake")
        }
    }

    val provider2 = object : PersonInfoProvider, Cat("katty"), Behavior {
        // 为接口中定义的属性赋值
        override val providerInfo: String
            get() = "new info provider"

        // 可以在匿名内部类中添加新方法
        fun getToken() = "token"

        // 可以在匿名内部类中添加新参数
        val age = 100

        override fun bake() {
            println("$name is bake")
        }
    }

    // 没有任何超类型，此时类型为 Any
    val person = object {
        val name = "jack"
        val age = 23

        fun printInfo() {
            println("name is $name, age is $age")
        }
    }

    provider.printInfo(Person())
    println(provider.getToken())
    println("age is ${provider.age}, name is ${provider.name}")
    provider.bake()
    // com.hc.kotlin.clazz.ObjectExpressionKt$main$provider$1@4dc63996
    // package.fileNameKt$functionName.objectName$Number@hash
    println(provider)
    // com.hc.kotlin.clazz.ObjectExpressionKt$main$provider2$1@d716361
    println(provider2)
    person.printInfo()
    // com.hc.kotlin.clazz.ObjectExpressionKt$main$person$1@6ff3c5b5
    println(person)

    var clickCount = 0

}

interface MouseAdapter {

}
