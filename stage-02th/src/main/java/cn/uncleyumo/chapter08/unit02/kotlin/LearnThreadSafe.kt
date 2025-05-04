package cn.uncleyumo.chapter08.unit02.kotlin

import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName `kotlin.LearnThreadSafe`
 * @createDate 5/4/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun main() {
//    stimulateThreadSafeQuestionUseCoroutine()
//    stimulateThreadSafeQuestionUseThread()
//    for (i in 1..10) stimulateThreadSafeQuestionUseThread()
}

fun stimulateThreadSafeQuestionUseThread() {
    val acc = Account(cardId = "ICBC-110", money = 100000.0)
    DrawThread(name = "Jimmy", acc = acc).start()
    DrawThread(name = "Marry", acc = acc).start()
}

class DrawThread(name: String, private val acc: Account) : Thread(name) {
    private val lock: Lock

    init {
        this.lock = ReentrantLock()
    }

    override fun run() {
        lock.lock()  // get lock
        try {
            acc.withdrawByThread(money = 100000.0)
        } catch (e: Exception) {
            LogPrinter.info("${Thread.currentThread().name} withdraw failed")
        } finally {
            lock.unlock()  // release lock
        }
    }
}

fun stimulateThreadSafeQuestionUseCoroutine() = runBlocking {
    val acc = Account(cardId = "ICBC-110", money = 100000.0)
    launch {
        acc.withdraw(money = 100000.0, name = "Jimmy")
    }
    launch {
        acc.withdraw(money = 100000.0, name = "Marry")
    }
}

data class Account(val cardId: String, var money: Double) {
    fun withdraw(money: Double, name: String) {
        if (money > this.money) {
            LogPrinter.info("Bank's money is not enough for $name, current money: ${this.money}$")
        } else {
            this.money -= money
            LogPrinter.info("$name withdraw $money$, current money: ${this.money}$")
        }
    }
    fun withdrawByThread(money: Double) {
        val name = Thread.currentThread().name
        if (money > this.money) {
            LogPrinter.info("$name's money is not enough, current money: ${this.money}$")
        } else {
            this.money -= money
            LogPrinter.info("$name withdraw $money$, current money: ${this.money}$")
        }
    }
}