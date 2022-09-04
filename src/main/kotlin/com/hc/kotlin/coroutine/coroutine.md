
## 简介
以同步语法，处理异步或非阻塞编程，避免回调地狱
kotlin使用挂起函数实现和futures(async/await), promises类似的功能
kotlin语言本身没有支持协程，需要使用核心库添加本功能：
在不损失可读性，不阻塞线程，不使用回调的情况下，提供异步功能

使用挂起函数执行耗时操作：网络请求、IO
使用协程执行并发操作
使用channel在协程间传递信息


## 协程与现存其它方案的区间



### 和线程的区别
协程中是一个任务(Job)，
一个线程中可以有很多个协程，他们可以在一个线程中并发执行

### delay和Thread.sleep
delay是暂停当前协程，Thread.sleep是暂停整个线程

### CoroutineScope或CoroutineContext
用于管理一组协程，这样做后可以使用一个动作对一组协程进行统一管理，如停止他们运行
创建协程组(CoroutineScope)时，需要传入CoroutineContext，有三种类型，分别是：
* Dispatchers.IO 访问网络或数据库
* Dispatchers.Main 在UI线程
* Dispatchers.Default CPU密集型工作

## 作用
* 挂起和恢复，可以控制执行流程的转移
* 异步逻辑可以用同步代码的形式写出


## 核心
挂起和恢复

### 挂起
* 以suspend修饰的函数是挂起函数
* 因为调用suspend函数时，编译器会默认传入一个Continuation参数，而这个参数只有在协程或挂起函数中时才存在，
  所以suspend函数只能在coroutine或其他suspend函数中被调用；类似于async函数只能在async函数中被调用，区别是少了await关键字； 
* suspend函数的返回值，如果是真正挂起，就返回挂起标志，通知调用者等待；如果不是真正挂起，就直接返回结果值，调用者拿到后继续执行。

## 参考资料
[Coroutine guide](https://kotlinlang.org/docs/coroutines-guide.html)
[Android 上的 Kotlin 协程](https://developer.android.com/kotlin/coroutines?hl=zh)  
[协程简介](https://developer.android.com/codelabs/basic-android-kotlin-training-introduction-coroutines#0)
[在 Android 应用中使用 Kotlin 协程](https://developer.android.com/codelabs/kotlin-coroutines#0)  
[学习采用 Kotlin Flow 和 LiveData 的高级协程](https://developer.android.com/codelabs/advanced-kotlin-coroutines#0)  
[Coroutines | Kotlin](https://kotlinlang.org/docs/coroutines-overview.html)
