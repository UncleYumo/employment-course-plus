package cn.uncleyumo.chapter10.unit02.realcase

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName SimulateJunit
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyTest(val level: Int = 1)


class TestMyTestAnnotation {
    fun run(level: Int = 5) {
        val clazz = this::class.java
        clazz.declaredMethods.forEach {
            if (it.isAnnotationPresent(MyTest::class.java)) {
                val anno = it.getDeclaredAnnotation(MyTest::class.java) as MyTest
                if (anno.level <= level) {
                    println("method: ${it.name}")
                    println("level: ${anno.level}")
                    it.invoke(this)
                    println()
                }
            }
        }
    }
    @MyTest()
    fun test01() {
        println("${"=".repeat(10)} test01 ${"=".repeat(10)}")
    }
    @MyTest(level = 2)
    fun test02() {
        println("${"=".repeat(10)} test02 ${"=".repeat(10)}")

    }
    @MyTest(level = 3)
    fun test03() {
        println("${"=".repeat(10)} test03 ${"=".repeat(10)}")

    }
    @MyTest(level = 4)
    fun test04() {
        println("${"=".repeat(10)} test04 ${"=".repeat(10)}")

    }
    @MyTest(level = 5)
    fun test05() {
        println("${"=".repeat(10)} test05 ${"=".repeat(10)}")

    }
}

fun main() {
    TestMyTestAnnotation().run(3)
}