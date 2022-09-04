package com.hc.kotlin.clazz

// 1. 当类中没有任何内容时，大括号可以省略
//class Person {
//}
//class Person

// 2. 主构造函数默认为 constructor()
// constructor关键字可以省略，把()直接加载类名名
// 如果主构造函数内容为空，()也可以省略
//class Person constructor()
//class Person()
//class Person

// 3. 自定义主构造函数
//class Person(_firstName: String, _lastName: String) {
//    // 4. 定义属性
//    // 初始化方式1：在定义时直接初始化
//    private val firstName: String = _firstName
//    private val lastName: String = _lastName
//
//    // 5. 对象创建后执行，用于初始化对象，在其它构造函数之前执行
//    // 初始化方式2：init
////    init {
////        firstName = _firstName
////        lastName = _lastName
////    }
//}

// 6. 在主构造函数中直接创建属性并初始化
//class Person(val firstName: String, val lastName: String) {
//
//    init {
//        // 在constructor前执行
//        println("init 1")
//    }
//
//    // 7. 定义其它构造函数
//    // 使用 constructor 关键字
//    // 需要调用主构造函数
//    constructor() : this("Peter", "Parker") {
//        // 8. 其它构造函数内部如果有其它工作要处理，可以添加方法体
//        println("secondary constructor")
//    }
//
//    init {
//        // 在constructor前执行，在init1后执行
//        println("init 2")
//    }
//
//}

// 9. 可以通过为主构造函数参数添加默认值，来替换其它构造函数
// 14. 类默认权限是public，全局可见，其它有internal(模块内可见), private(文件内可见)
// 16. 类默认为final，不可被继承，为open时才可被继承
open class Person(val firstName: String = "Peter", val lastName: String = "Parker") {

    // 10. 定义属性
    // kotlin 默认会为var添加getter和setter，为val添加getter
    // 可以重写这些方法，提供自定义逻辑
    var nickName: String? = null
        set(value) {
            // 11. 当nickName的set被调用时会执行到这里
            // 需要在这里使用 field 引用属性并为其设置值，否则它的值不会改变
            field = value
            println("the new nickName is $value")
        }
        get() {
            // 12. 当nickName的get被调用时会执行到这里
            println("the returned value is $field")
            // 必须指定返回值，否则没有值会返回
            return field
        }

    // 15. 属性默认权限为public，其他权限有internal(模块内)，protected(本类和子类中)，private(文件内)
    // protected在final类中实际为private，类为open时才可在子类中访问
    protected var age: Int = 3

    // 13. 创建方法
    fun printInfo() {
//        val nickNamePrint = if (nickName != null) nickName else "no nickname"
        // ?: 检查左侧是否为空，如果不为空，取左侧值返回，否则取右侧值返回。等价于上面的if语句
        val nickNamePrint = nickName ?: "no nickname"
        println("$firstName ($nickNamePrint) $lastName")
    }
}
