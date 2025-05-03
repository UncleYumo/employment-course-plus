package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.LogPrinter
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask
import kotlin.random.Random

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName LearnCallable
 * @createDate 5/3/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

data class Stu(val name: String? = null, val age: Int? = null)

class MyCallable(private val stuName: String) : Callable<Stu> {
    override fun call(): Stu {
        LogPrinter.debug("Start getting stu info from net")
        Thread.sleep(1000L)
        if (stuName == "uncleyumo") throw RuntimeException("Get stu info from net failed")
        LogPrinter.debug("Get stu info from net success")
        return Stu(stuName, Random.nextInt(18, 28))
    }
}

fun main() {
    LogPrinter.debug("Main: Start")
    val futureTask = FutureTask(MyCallable("超级大坏蛋"))
    Thread(futureTask).start()
    try {
        val stu = futureTask.get()  // The get() method will block the main thread
        LogPrinter.info("Main: Get stu info success, stu info is $stu")
    } catch (e: Exception) {
        LogPrinter.debug("Main: Get stu info failed, error is $e")
    }
    LogPrinter.debug("Main: End")
}