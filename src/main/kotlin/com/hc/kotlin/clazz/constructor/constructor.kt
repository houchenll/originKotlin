package com.hc.kotlin.clazz.constructor

// 类包含一个主构造函数和多个副构造函数

// 主构造函数是 class header 的一部分，在 class name 后，拥有可选的类型参数
class Person1 constructor(firstName: String)

// 如果主构造没有任何注解或可见性修饰符，则 constructor 关键字可省略
class Person2(firstName: String)

// 主构造函数没有包含任何代码
// 初始化代码可放置在 init 关键字后的代码块中，init 初始化代码可有多块
// 当初始化实例时，多个 init 代码块及交互属性初始化的执行顺序和它们在class中的定位顺序相同
// 主构造函数中的参数不是属性，但可以在 init 代码块及 class 中定义的属性初始化时使用
class InitOrderDemo(name: String) {
    val firstProperty = "First property $name".also(::println)

    init {
        println("first initializer block that prints $name")
    }

    val secondProperty = "Second property $name".also(::println)

    init {
        println("second initializer block that prints $name")
    }
}

// 主构造函数中可以直接定义且初始化属性
// 与参数的区别是添加了 val or var 修饰符
class Person3(val firstName: String, val lastName: String, var age: Int = 20)

// 定义类属性时支持 trailing comma
class Person4(
    val firstName: String,
    val lastName: String,
    var age: Int = 20,
)

annotation class Inject

// 如果主构造函数包含 注解 或 有可见性修饰符，那么 constructor 关键字是必需的，
// 顺序为：ClassName -> 注解 -> 可见性修饰符 -> constructor
class Customer @Inject private constructor(name: String)

// 同时具有无参主构造函数和有参副构造函数
class Bean(@Inject var date: String? = null, @Inject var result: String? = null) {
    override fun toString(): String {
        return "Bean=(date=$date, result=$result)"
    }
}

// class 可以使用 constructor 在类中定义副构造函数
class Person5(val pets: MutableList<Pet> = mutableListOf())

class Pet {
    constructor(owner: Person5) {
        owner.pets.add(this)
    }
}

// 如果类有主构造函数，那么每个副构造函数都需要委托给主构造函数。或者直接，或者通过其它副构造函数间接
// 委托给本类的其它构造函数使用 this 关键字，并在 this 前添加 :
class Person6(val name: String) {
    private val children: MutableList<Person6> = mutableListOf()

    constructor(name: String, parent: Person6) : this(name) {
        parent.children.add(this)
    }
}

// 初始化块和类属性初始化是主构造函数的一部分
// 委托给主构造函数发生在次构造函数体执行前，所以所有的初始化块和类属性初始化发生在次构造函数体执行前

// 即使没有主构造函数，委托也会隐式地发生，初始化块也会执行
class Constructors {
    init {
        println("Init block 1")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }

    init {
        // 在 constructor 前执行
        println("Init block 2")
    }
}

// 如果一个非抽象类没有声明任何构造函数（主或副），它会自动生成一个 public 的无参构造函数

// 如果想要类没有 public 构造函数，可以声明一个 private 的 空的主构造函数
class DontCreateMe private constructor ()

// 在JVM上，当主构造函数的所有参数都有默认值时，编译器会自动另外生成一个无参构造函数且使用默认值
// 这个特性方便 Jackson 或 JPA 使用，它们使用无参构造函数创建实例
class Customer2(val name: String = "jack", val age: Int = 23)

fun main() {
//    val initDemo1 = InitOrderDemo("jack")

//    val bean1 = Bean()
//    println(bean1)
//    val bean2 = Bean("20220511", "response")
//    println(bean2)

//    val con = Constructors(1)

//    val customer = Customer2()
//    println("name ${customer.name}")
//    val customer2 = Customer2("jame", 18)
}
