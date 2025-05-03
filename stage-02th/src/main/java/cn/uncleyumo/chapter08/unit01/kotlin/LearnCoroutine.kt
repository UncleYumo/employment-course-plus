package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName LearnCoroutine
 * @createDate 5/3/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun entryPoint() = runBlocking {  // root coroutine
    LogPrinter.info("root coroutine start")
    launch {   // sub-coroutine
        LogPrinter.info("sub01 coroutine start")
        LogPrinter.info("delay 1000L")
        delay(10L)
        for (i in 1..10) {
            delay(10L)
            ColorPrinter.printlnFontGreen("$i ")
        }
        LogPrinter.info("sub01 coroutine end")
    }
    launch {   // sub-coroutine
        LogPrinter.info("sub02 coroutine start")
        LogPrinter.info("delay 1000L")
        delay(10L)
        for (i in 1..10) {
            delay(10L)
            ColorPrinter.printlnFontBlue("$i ")
        }
        LogPrinter.info("sub02 coroutine end")
    }
    LogPrinter.info("root coroutine end")
    entryPoint2()
}

suspend fun entryPoint2() = coroutineScope {
    for (i in 1..10) {
        delay(10L)
        ColorPrinter.printlnFontRed("$i ")
    }
}

fun main() {
    entryPoint()
    for (i in 1..10) {
        ColorPrinter.printlnFontCyan("$i ")
    }
}