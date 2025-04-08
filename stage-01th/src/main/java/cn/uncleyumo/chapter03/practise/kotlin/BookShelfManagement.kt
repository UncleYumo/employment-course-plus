package cn.uncleyumo.chapter03.practise.kotlin

/**
 * @author uncle_yumo
 * @fileName BookShelfManagement
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description 书籍管理集合操作示例
 */

data class Book(
    val name: String,
    val price: Double,
    val author: String
)

private val bookList = mutableListOf(
    Book("Java编程思想", 76.9, "布鲁斯·埃克尔"),
    Book("Java核心技术卷", 104.7, "霍斯特曼"),
    Book("Java性能优化", 94.8, "查理.亨特"),
    Book("Java并发编程之美", 44.5, "翟陆续")
)

fun manageBookshelf() {
    // 移除指定书籍
    bookList.removeIf { it.name == "Java并发编程之美" }

    println("当前书架书籍：")
    bookList.forEach {
        println("书名：《${it.name}》 价格：${it.price}元 作者：${it.author}")
    }
}

fun main() {
    manageBookshelf()
}
