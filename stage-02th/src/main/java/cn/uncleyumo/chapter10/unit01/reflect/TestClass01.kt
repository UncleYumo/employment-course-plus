package cn.uncleyumo.chapter10.unit01.reflect

import cn.uncleyumo.utils.LogPrinter

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TestClass01
 * @createDate 5/20/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun main() {
    testUseConstructors()
}

fun testUseConstructors() {
    val clazz = Student::class.java
    val constructorWithArgs = clazz.getDeclaredConstructor(String::class.java, Int::class.java)

    println("getConstructorWithArgs: ${constructorWithArgs.name} ---> ${constructorWithArgs.parameterCount}")

    val student = constructorWithArgs.newInstance("new instance", 221) as Student
    val getNameMethod = clazz.getMethod("getStuName")
    val getAgeMethod = clazz.getMethod("getStuAge")
    val name = getNameMethod.invoke(student) as String
    val age = getAgeMethod.invoke(student) as Int

    println("name: $name, age: $age")
}

fun testGetDeclaredConstructors() {
    val clazz = Student::class.java
    val constructors = clazz.declaredConstructors
    constructors.forEach { con ->
        println(con.name.plus(" ---> ".plus(con.parameterCount)))
    }
    val constructor = clazz.getDeclaredConstructor()  // get no args constructor
    println("getConstructor: ${constructor.name} ---> ${constructor.parameterCount}")
    val constructorWithArgs = clazz.getDeclaredConstructor(String::class.java, Int::class.java)
    println("getConstructorWithArgs: ${constructorWithArgs.name} ---> ${constructorWithArgs.parameterCount}")
}

fun testGetClass() {
    val clazzOfStudent = Student().javaClass
    LogPrinter.info("getClassName: ${clazzOfStudent.name}")
    LogPrinter.info("getClassSimpleName: ${clazzOfStudent.simpleName}")
    LogPrinter.info("getClassPackageName: ${clazzOfStudent.packageName}")
    println()

    val clazz = Class.forName("cn.uncleyumo.chapter10.unit01.reflect.Student")
    println(clazzOfStudent == clazz)
}