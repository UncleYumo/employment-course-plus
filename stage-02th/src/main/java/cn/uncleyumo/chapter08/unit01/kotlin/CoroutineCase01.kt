package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.ColorPrinter
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName CoroutineCase01
 * @createDate 5/3/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

suspend fun downloadFile01(): String {
    delay(1000L)
    ColorPrinter.printlnFontGreen("File01 downloaded successfully")
    return "File01"
}

suspend fun downloadFile02(): String {
    delay(1000L)
    ColorPrinter.printlnFontGreen("File02 downloaded successfully")
    return "File02"
}

fun test01() = runBlocking {
    val file01 = async { downloadFile01() }
    val file02 = async { downloadFile02() }
    ColorPrinter.printlnFontYellow(
        "Files downloaded successfully: ${file01.await()} and ${file02.await()}"
    )
}

fun test02() = runBlocking {
    val file01 = downloadFile01()
    val file02 = downloadFile02()
    ColorPrinter.printlnFontYellow(
        "Files downloaded successfully: $file01 and $file02"
    )
}

fun main() {
    test02()
    ColorPrinter.printlnFontRed("Done")
}