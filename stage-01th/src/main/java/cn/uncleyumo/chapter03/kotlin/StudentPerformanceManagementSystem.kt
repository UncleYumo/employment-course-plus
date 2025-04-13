package cn.uncleyumo.chapter03.kotlin

/**
 * @author uncle_yumo
 * @fileName StudentPerformanceManagementSystem
 * @createDate 2025/4/9 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

data class Student(
    val name: String? = null,
    val age: Int? = null,
    val gender: String? = null,
    val score: Int? = null,
)

private val studentList = mutableListOf<Student>()

fun start() {
    while (studentList.size < 3) {
        println("请输入第${studentList.size + 1}个学生的信息：")
        println("姓名：")
        val name = readlnOrNull()
        println("年龄：")
        val age = readlnOrNull()?.toIntOrNull()
        println("性别：")
        val gender = readlnOrNull()
        println("分数：")
        val score = readlnOrNull()?.toIntOrNull()
        if (name!= null && age != null && gender != null && score != null) {
            studentList.add(Student(name, age, gender, score))
            println("添加成功！")
        }
        println()
    }
    println("学生信息如下：")
    studentList.forEach { println(it) }
}

fun main() {
    start()
}