package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName CoroutineCase02
 * @createDate 5/3/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun point() = runBlocking {
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

fun main() {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()
    val task = executor.submit {
        var i = 0
        try {
            while (!Thread.currentThread().isInterrupted) {
                ColorPrinter.printlnFontCyan("Job is running ${i++}")
                Thread.sleep(500L)
            }
        } catch (e: InterruptedException) {
            // 线程被中断，退出循环
            ColorPrinter.printlnFontRed("Main: Job is cancelled due to interruption")
        } finally {
            // 确保线程退出后关闭 ExecutorService
            executor.shutdown()
        }
    }

    Thread.sleep(1500L)
    task.cancel(true)
}
