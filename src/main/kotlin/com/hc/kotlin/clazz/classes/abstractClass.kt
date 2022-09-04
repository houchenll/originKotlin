package com.hc.kotlin.clazz.classes

// 一个类和它的一部分或全部成员，可以被声明为 abstract
// abstract 成员在当前类中没有实现
// abstract class 和 function 不需要用 open 修饰
abstract class Polygon {
    abstract fun draw()

    // 可被子类覆写的非抽象方法，需要声明为 open
    open fun setColor(color: String) {
        // do some default thing
    }
}

class Rectangle : Polygon() {
    override fun draw() {
        // draw the rectangle
    }
}

abstract class WildShape : Polygon() {
    override fun draw() {
        // draw the wildShape
    }

    // 可以用子类 abstract 成员覆写父类 open 的非 abstract 成员
    abstract override fun setColor(color: String)
}
