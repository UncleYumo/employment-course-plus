package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName LearnThread
 * @createDate 5/2/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun main() {
    val t01: Thread = MyThread("0t00")
    val t02: Thread = MyThread("1t01")
    t01.start()
    t02.start()
}

class MyThread(tName: String) : Thread(tName) {
    override fun run() {
        for (i in 0..10) {
            if (this.name.startsWith("0"))
                LogPrinter.info("${this.name}\t$i")
            else LogPrinter.debug("${this.name}\t$i")
            sleep(10)
        }
    }
}