package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.ColorPrinter
import kotlinx.coroutines.delay

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName LearnRunnable
 * @createDate 5/3/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class MyRunnable(private val name: String): Runnable {
    override fun run() {
        val last = name.last()
        for (i in 1..10) {
            when (last) {
                '1' -> ColorPrinter.printlnFontCyan("MyRunnable(${name}): $i")
                '2' -> ColorPrinter.printlnFontBlue("MyRunnable(${name}): $i")
                '3' -> ColorPrinter.printlnFontGreen("MyRunnable(${name}): $i")
                else -> ColorPrinter.printlnFontWhite("MyRunnable(${name}): $i")
            }
            Thread.sleep(100L)
        }
    }
}

fun main() {
    Thread(MyRunnable("test1")).start()
    Thread {
        for (i in 1..10) {
            ColorPrinter.printlnFontCyan("Runnable: $i")
            Thread.sleep(100L)
        }
    }.start()
}