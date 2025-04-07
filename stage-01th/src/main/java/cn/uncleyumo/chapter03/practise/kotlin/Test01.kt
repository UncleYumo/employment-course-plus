package cn.uncleyumo.chapter03.practise.kotlin

/**
 * @author uncle_yumo
 * @fileName Case01
 * @createDate 2025/4/6 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

fun main() {
    practise02()
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