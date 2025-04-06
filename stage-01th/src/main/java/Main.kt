import cn.uncleyumo.chapter03.Chapter03
import cn.uncleyumo.chapter03.hiHitler
import cn.uncleyumo.utils.enum.BackGroundColorEnum
import cn.uncleyumo.utils.enum.FontStyleEnum
import cn.uncleyumo.utils.enum.FrontColorEnum
import cn.uncleyumo.utils.pojo.MetaPrinter

/**
 * @author uncle_yumo
 * @fileName Main
 * @createDate 2025/4/6 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

//const val name = "KotlinQuickStart"
//const val age = 25
//val chapter03 = Chapter03(name, age)
//
//fun main() {
//    hiHitler()
//}
//
//fun thisIsAFunction() {
//    println("This is a function")
//    MetaPrinter.addBackgroundColor(BackGroundColorEnum.GREEN)
//        .addFontColor(FrontColorEnum.BLACK)
//        .addFontStyle(FontStyleEnum.ITALIC)
//        .println("This is a meta message")
//}

private var currentId: Long? = null
private var currentName: String? = null

@JvmOverloads   // 允许重载
fun init(cId: Long = 1L, cName: String = "Default-Name") {
    currentId = cId
    currentName = cName
}

fun showInfo() {
    println("Current Id: $currentId, Current Name: $currentName")
}

fun setCurrentId(id: Long) {
    currentId = id
}

fun setCurrentName(name: String) {
    currentName = name
}

fun main() {
    showInfo()
    init(cId = 110L)
    showInfo()
    init()
    showInfo()
    setCurrentName("New Name")
    showInfo()
}
