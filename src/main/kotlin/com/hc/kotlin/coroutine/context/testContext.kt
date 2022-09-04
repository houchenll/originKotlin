package com.hc.kotlin.coroutine.context

public interface CoroutineContext {

    //操作符[]重载，可以通过CoroutineContext[Key]这种形式来获取与Key关联的Element
    public operator fun <E : Element> get(key: Key<E>): E?

    //它是一个聚集函数，提供了从left到right遍历CoroutineContext中每一个Element的能力，并对每一个Element做operation操作
    public fun <R> fold(initial: R, operation: (R, Element) -> R): R

    //操作符+重载，可以CoroutineContext + CoroutineContext这种形式把两个CoroutineContext合并成一个
    public operator fun plus(context: CoroutineContext): CoroutineContext

    //返回一个新的CoroutineContext，这个CoroutineContext删除了Key对应的Element
    public fun minusKey(key: Key<*>): CoroutineContext

    //Key定义，空实现，仅仅做一个标识
    public interface Key<E : Element>

    //Element定义，每个Element都是一个CoroutineContext
    public interface Element : CoroutineContext {

        //每个Element都有一个Key实例
        public val key: Key<*>

        //...
    }
}
