package cn.uncleyumo.chapter03

import cn.uncleyumo.utils.ColorPrinter

/**
 * @author uncle_yumo
 * @fileName Chapter03
 * @createDate 2025/4/6 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

class Chapter03(
    private var name: String?,
    private var age: Int?
) {
    constructor() : this(null, null) {
        this.name = "Default Name"
        this.age = 0
    }

    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String = "Chapter03(name=$name, age=$age)"
}

data class Person(
    var name: String?,
    var age: Int?
) {
    constructor(): this(null, null) {
        this.name = null
        this.age = 0
    }

    fun hiHitler(): String = "Hi Hitler!"
}

fun main() {
    val c1 = Chapter03("UncleYumo", 22)
    println(c1)
    val c2 = Chapter03();
    println(c2)
    ColorPrinter.printlnCyanRed(Person().apply {
        name = "UncleYumo"
        hiHitler()
        println(this.hiHitler())
        age = 22
    }.toString())
    hiHitler()
//    thisIsAFunction()
}

fun hiHitler(): String = "Hi Hitler! from package function"