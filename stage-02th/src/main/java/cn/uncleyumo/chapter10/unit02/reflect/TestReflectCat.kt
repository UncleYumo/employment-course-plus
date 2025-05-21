package cn.uncleyumo.chapter10.unit02.reflect

import lombok.ToString

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TestReflectCat
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class Cat {
    private var name: String? = null
    private var age: Int? = null

    constructor() {
        println("无参构造函数")
    }

    constructor(name: String, age: Int) {
        println("有参构造函数")
        this.name = name
        this.age = age
    }

    companion object {
        var a: Int? = null
        const val COUNTRY: String = "中国"
    }

    override fun toString(): String {
        return """
            Cat {
                name = $name
                age = $age
            }
        """.trimIndent()
    }
}

data class Dog(
    var name: String? = null,
    var age: Int? = null
) {
    fun comeOfAge() = run { age = 10 }
    override fun toString(): String {
        return """
            Dog {
                name = $name
                age = $age
            }
        """.trimIndent()
    }
}

fun main() {
    testMethod()
}

fun testMethod() {
    val clazz = Dog::class.java
    val constructors = clazz.constructors
    for (constructor in constructors) {
        println("${constructor.name} ---> ${constructor.parameterTypes.joinToString()}")
    }
    println()
    val declaredMethods = clazz.declaredMethods
    for (method in declaredMethods) {
        println(
            "${method.name.padEnd(12, ' ')} --> ${
                method.parameterCount.toString().padEnd(2, ' ')
            } --> ${
                method.parameterTypes.joinToString().let {
                    var temp = it
                    if (temp.isBlank()) temp += "void"
                    temp
                }
            }"
        )
    }
    println()
    val method = clazz.getDeclaredMethod("comeOfAge")
    method.isAccessible = true
    val dog = Dog()
    println(dog)
    println()
    method.invoke(dog)
    println(dog)
}

fun testField() {
    val clazz = Cat::class.java
    val fields = clazz.fields
    for (field in fields) {
        println("${field.name} ---> ${field.type}")
    }
    println()
    val declaredFields = clazz.declaredFields
    for (field in declaredFields) {
        println("${field.name} ---> ${field.type}")
    }
    println()
    val cat = Cat()
    val fName = clazz.getDeclaredField("name")
    fName.isAccessible = true
    fName.set(cat, "Test Name")
    println("fName.get(cat): ${fName.get(cat)}")
    val fAge = clazz.getDeclaredField("age")
    fAge.isAccessible = true
    fAge.set(cat, 10)
    println("fAge.get(cat): ${fAge.get(cat)}")
    val fA = clazz.getDeclaredField("a")
    fA.isAccessible = true
    fA.set(null, 10)
    println("fA.get(null): ${fA.get(null)}")
    val fCountry = clazz.getDeclaredField("COUNTRY")
    fCountry.isAccessible = true
    println("fCountry.get(null): ${fCountry.get(null)}")
    println()
    println(cat)
}
