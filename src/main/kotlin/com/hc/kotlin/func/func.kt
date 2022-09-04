package com.hc.kotlin.func

// fun 1：标准函数实现
fun getGreeting(): String {
    return "Hello Kotlin"
}

// Unit 表示没有返回有意义的类型，是冗余的，可以省略
fun sayHello(): Unit {
    println(getGreeting())
}

// fun 2：单表达式函数
// 当方法体内只有一条语句时，可以省略方法体，用表达式代替
// 返回类型可以推断，也可以省略
fun getGreeting2() = "Hello Kotlin"

// fun 3：普通参数函数
fun sayHello(itemToGreet: String) = println("Hello $itemToGreet")

// fun 4: named 参数
// 调用时可以交换参数顺序
// named arguments 不能和 vararg 一起使用，vararg也需要指明参数名称
// greetPeople("Hi", "jack")
// greetPeople(greeting = "Hi", name = "jack")
// greetPeople(name = "jack", greeting = "Hi")
fun greetPeople(greeting: String, name: String) = println("$greeting $name")

// fun 5: vararg 参数，表达0到多个同一类型数据
// sayHello("Hi", "kotlin", "java", "cpp")
// sayHello("Hi", *arrayOf("kotlin", "java", "cpp"))
fun sayHello(greeting: String, vararg itemsToGreet: String) {
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

// fun 6: 默认值参数
// greetStudent(name = "jack")
// greetStudent(greeting = "Hi", name = "jack")
// greetStudent("Hi", "jack")
fun greetStudent(greeting: String = "Hello", name: String) = println("$greeting $name")

fun main() {
//    println(getGreeting2())
//    sayHello()
//    sayHello("Jack")

//    sayHello("Hi", "kotlin", "java", "cpp")
    // 在array前添加*，可以得到遍历array后的结果
//    sayHello("Hi", *arrayOf("kotlin", "java", "cpp"))

//    greetPeople("Hi", "jack")
//    greetPeople(greeting = "Hi", name = "jack")
//    greetPeople(name = "jack", greeting = "Hi")

//    greetStudent(name = "jack")
//    greetStudent(greeting = "Hi", name = "jack")
//    greetStudent("Hi", "jack")
}
