package com.hc.kotlin.func

fun main() {
    val double = double(3)
    foo(baz = 1)
    foo1 { println("foo1 executed 1") }
    foo1(qux = { println("foo1 executed 2") })
    foo1 { println("foo1 executed 3") }
}

fun double(x: Int): Int {
    return 2 * x
}

// 单表达式函数
// 当函数体只返回一条表达式时，花括号可省略，用=连接函数声明和表达式
// 当返回类型可推断时，返回类型声明可省略
fun double1(x: Int): Int = 2 * x
fun double2(x: Int) = 2 * x

// 明确指定返回类型
// 当函数有方法体，且返回值不是Unit时，必须明确指定返回类型
// 因为函数有方法体时，方法体内逻辑可能很复杂，难以推断返回类型

// 参数
// 1. 每个参数都必须明确指定类型
// 2. 可以使用 trailing comma 语法
// 3. 可以为参数指定默认值。如果父类方法参数有默认值，子类覆写方法继承这个默认值，且必须省略默认值声明；
// 如果有两个默认值，只传入一个参数值，且没有指定名称时，默认把值传递给第一个参数；
// 4. 如果有默认值参数先于无默认值参数，只有当指定无默认值参数名调用时，默认值才有效
fun foo(bar: Int = 0, baz: Int) {}
// 5. 参数顺序：无默认值参数、有默认值参数、lambda
// 6. 当默认值后的最后一个参数是函数时，可以用lambda作为参数。lambda可以指定参数名调用，也可以放在函数调用后。
// 当函数调用后有lambda时，如果函数调用没有其它参数，不用加括弧，如果指定了其它参数，才需要加括弧
fun foo1(
    first: Int = 4,
    name: String = "Jack",
    second: Int = 5,
    qux: () -> Unit,
) {
    println("first $first, name $name, second $second")
    qux()
}
fun foo2(first: Int = 4, second: Int = 5) {}
