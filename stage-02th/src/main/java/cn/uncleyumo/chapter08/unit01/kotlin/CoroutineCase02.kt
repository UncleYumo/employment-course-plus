package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName CoroutineCase02
 * @createDate 5/3/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(100) { i ->  // launch a new coroutine and continue
                ColorPrinter.printlnFontCyan("Job is running $i")
                delay(500L)  // Delay for 500ms
            }
        } catch (e: Exception) {
            LogPrinter.error(e.message ?: "No Error Message")
        }
    }
    delay(1500L)
    job.cancel()  // Cancel child coroutine
    job.join()  // Wait until child coroutine completes
    ColorPrinter.printlnFontRed("Main: Job is cancelled")
}