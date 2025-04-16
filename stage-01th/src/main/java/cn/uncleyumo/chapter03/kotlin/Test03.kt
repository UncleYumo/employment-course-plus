package cn.uncleyumo.chapter03.kotlin

/**
 * @author uncle_yumo
 * @fileName Test03
 * @createDate 2025/4/16 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

fun main() {
    val food01 = Food()
    val food02 = Food()
    println(food01 === food02)
    println(food01 == food02)
    println(System.identityHashCode(food01))
    println(System.identityHashCode(food02))
}