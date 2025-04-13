package cn.uncleyumo.chapter03.kotlin

import kotlin.random.Random

/**
 * @author uncle_yumo
 * @fileName Case01
 * @createDate 2025/4/6 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

fun main() {
//    practise02()
    println(generateRandomOrderNumber())
}

fun practise02() {
    val list: MutableList<String> = ArrayList()
    list.add("Java入门")
    list.add("宁夏枸杞")
    list.add("人字拖")
    list.add("特级枸杞")
    list.add("枸杞子")

    list.forEach {
        if (it == "枸杞子") list.remove(it)
    }

}

/*需求 : 对字符串进行遍历操作, 可以使用下列的哪些方法 ? 具体怎么遍历呢 ?*/
fun practise01() {
    // 1. toCharArray() 方法
    val str: String = "hello world"
    val chars: CharArray = str.toCharArray()

    // 2. charAt() 方法

    // 3. split() 方法
}

/**
 * 完成随机产生订单号，订单号一共有4组16位符号组成，每组用横杠-隔开，每组有4位。
 * 每位可能是数字、大写字母、小写字母。例如：KomY-STXw-s8iX-TEqK。
 * 请使用代码完成生成随机订单号的功能，并打印到控制台上。
 */
fun generateRandomOrderNumber(): String {
    val template = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    val random = Random(System.currentTimeMillis())
    val sb = StringBuilder()
    for (i in 0..3) {
        for (j in 0..3) {
            sb.append(template[random.nextInt(template.length)])
        }
        sb.append("-")
    }
    return sb.substring(0, sb.length - 1)
}