package com.hc.kotlin.clazz

import com.hc.kotlin.interfaze.BasicInfoProvider

// 1. 使用 : 继承
// 2. 被继承类需要使用 open 修饰
// 3. 被继承类需要指定构造函数
class FancyInfoProvider : BasicInfoProvider() {

    override val providerInfo: String
        get() = "Fancy Info Provider"

    // 4. 被覆写父类属性需要修改为 open，默认为 final
    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy Info")
    }

}

fun main() {
    val provider = FancyInfoProvider()
    provider.printInfo(Person())
}
