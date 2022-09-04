package com.hc.kotlin.interfaze

import com.hc.kotlin.clazz.Person

// 1. 定义接口时，如果接口内容为空，大括号可以省略
interface PersonInfoProvider {
//    fun printInfo(person: Person)

    // 4. 接口中可以定义属性，它只能在实现类中赋值
    val providerInfo: String

    // 3. 可以把公共逻辑放在接口的方法中，提供公共实现
    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {

    fun getSessionId(): String

}

// 2. 类实现接口时，使用 :
open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {

    // 4. 子类实现接口的属性
    override val providerInfo: String
        get() = "BasicInfoProvider"

    protected open val sessionIdPrefix = "SessionId"

    // 5. 子类继承实现接口的方法，需要调用super调用接口的默认实现
    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

fun main() {
    val provider = BasicInfoProvider()
    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
}

fun checkTypes(provider: PersonInfoProvider) {
    // 6. 检查对象是否属于某个类型：is or !is
    if (provider is SessionInfoProvider) {
        println("is a session info provider")

        // 7. 类型 cast
        (provider as SessionInfoProvider).getSessionId()

        // 8. smart cast, 当已检查确认了类型时，可以不用显式转换类型，直接使用
        provider.getSessionId()
    } else {
        println("not a session info provider")
    }
}
