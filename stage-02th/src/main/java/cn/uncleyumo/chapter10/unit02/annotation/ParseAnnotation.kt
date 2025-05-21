package cn.uncleyumo.chapter10.unit02.annotation

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName ParseAnnotation
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyTest04(
    val value: String,
    val aaa: Double = 100.0,
    val bbb: Array<String>
)

@MyTest04("蜘蛛精", 99.5, ["至尊宝", "黑马"])
class Demo {
    @MyTest04("孙悟空", bbb = ["紫霞", "刘夫人"])
    fun test01() {

    }
}

fun parseClass() {
    val clazz = Demo::class.java
    if (clazz.isAnnotationPresent(MyTest04::class.java)) {
        val annotation = clazz.getDeclaredAnnotation(MyTest04::class.java) as MyTest04
        println(annotation.value)
        println(annotation.aaa)
        println(annotation.bbb.joinToString())
    }
}

fun parseMethod() {
    val method = Demo::class.java.getDeclaredMethod("test01")
    if (method.isAnnotationPresent(MyTest04::class.java)) {
        val annotation = method.getDeclaredAnnotation(MyTest04::class.java) as MyTest04
        println(annotation.value)
        println(annotation.aaa)
        println(annotation.bbb.joinToString())
    }
}

fun main() {
    parseClass()
    println()
    parseMethod()
}