@file:Suppress("NonAsciiCharacters", "FunctionName", "ClassName", "LocalVariableName", "PropertyName")

package cn.uncleyumo.chapter09.unit01.kotlin

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test02
 * @createDate 5/12/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

interface 动物接口 {
    val 姓名: String
    val 年龄: Int
    fun 吃东西()
    fun 睡觉()
    fun 获取显示信息() = "姓名：${姓名}，年龄：${年龄}"
}

class 狗(override val 姓名: String, override val 年龄: Int) : 动物接口 {
    override fun 吃东西() = 打印("狗吃狗粮")
    override fun 睡觉() = 打印("狗睡觉")
}

class 猫(override val 姓名: String, override val 年龄: Int) : 动物接口 {
    override fun 吃东西() = 打印("猫吃猫粮")
    override fun 睡觉() = 打印("猫睡觉")
}

fun 打印(文字: String) = println(文字)

fun 主函数() {
    val 动物: 动物接口 = 狗("旺财", 3)
//    val 动物: 动物接口 = 猫("小花", 2)
    动物.吃东西()
    动物.睡觉()
    打印(动物.获取显示信息())
}

fun main() {
    打印("主函数开始")
    主函数()
    打印("主函数结束")
}