package cn.uncleyumo.chapter10.unit02.annotation

import java.lang.annotation.ElementType.*

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName CustomAnnotation02
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)  // Declare retention policy
annotation class CustomAnnotation02(
    val value: String,
    val language: String = "Kotlin",
    val version: Int
)
