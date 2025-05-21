package cn.uncleyumo.chapter10.unit02.annotation

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName use
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@CustomAnnotation01(aaa = "牛魔王", bbb = false, ccc = ["java", "kotlin"])
class TestCustomAnnotation01 {

}

@CustomAnnotation02("Test Value", version = 1)
class TestCustomAnnotation02 {

    private val field = "Test Value"

    @CustomAnnotation02("Test Value", version = 1)
    fun method(): String {
        return field
    }
}

fun main() {
    
}