package cn.uncleyumo.chapter10.unit02.realcase

import java.io.File
import java.io.FileOutputStream
import java.io.PrintStream

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName ObjectFrame
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description This file provides the function which is used to store the data of any Object to the local storage(file)
 */

data class Student(val name: String, val age: Int, val sex: String, val grade: Int, val major: String)
data class Teacher(val name: String, val age: Int, val degree: String, val subject: String)

fun main() {
    val student = Student("小明", 21, "男", 2020, "软件工程")
    val teacher = Teacher("小红", 30, "PhD", "计算机")
    saveObject(student)
    saveObject(teacher)
}

fun saveObject(obj: Any) {
    FileOutputStream(staticFilePath(), true).use {
        PrintStream(it).use { ps ->
            val clazz = obj::class.java
            val simpleName = clazz.simpleName
            // get all fields of obj
            val fields = clazz.declaredFields
            ps.println(("${"-".repeat(10)} ${simpleName.padEnd(8, ' ')} ${"-".repeat(10)}"))
            fields.forEach { field ->
                field.isAccessible = true
                val name = field.name
                val value = field.get(obj).toString()
                ps.println(("${name.padEnd(8, ' ')} =\t$value"))
            }
            ps.println()
        }
    }
}

fun srcPath(pathList: List<String>): String {
    return System.getProperty("user.dir").plus(File.separator).plus(pathList.joinToString(File.separator))
}

fun staticFilePath(filePath: List<String> = listOf()) = srcPath(
    listOf(
        "stage-02th",
        "src",
        "main",
        "resources",
        "static"
    )
).let {
    val path =
        if (filePath.isNotEmpty()) it.plus(File.separator).plus(filePath.joinToString(File.separator))
        else it.plus(File.separator).plus("object.txt")
    path
}