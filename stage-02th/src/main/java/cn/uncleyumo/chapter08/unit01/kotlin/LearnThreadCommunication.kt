package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.runBlocking

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName LearnThreadCommunication
 * @createDate 5/4/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class Desk {
    private var list: List<String> = ArrayList()
    private var lock = Object()

    fun put() {
        synchronized(lock) {
            val name = Thread.currentThread().name
            // judge if the desk has baozi left
            if (list.isEmpty()) {
                list += "baozi of $name"
                LogPrinter.info("$name put baozi, current size is ${list.size}")
                Thread.sleep(2000L)

                // wait for the list to be empty, and notify the waiting thread
                lock.notifyAll()
                lock.wait()
            } else {
                // wait for the list to be empty, and notify the waiting thread
                lock.notifyAll()
                lock.wait()
            }
        }
    }

    fun get() {
        synchronized(lock) {
            val name = Thread.currentThread().name
            if (list.size == 1) {
                val baozi = list[0]
                list = list.drop(1)
                LogPrinter.debug("$name get $baozi, current size is ${list.size}")
                Thread.sleep(200L)
                lock.notifyAll()
                lock.wait()
            } else {
                lock.notifyAll()
                lock.wait()
            }
        }
    }
}

fun coroutinePoint01() = runBlocking {

}

fun threadPoint01() {
    val desk = Desk()

    Thread({
        while (true) {
            desk.put()
        }
    }, "CHEF01").start()

    Thread({
        while (true) {
            desk.put()
        }
    }, "CHEF02").start()

    Thread({
        while (true) {
            desk.put()
        }
    }, "CHEF03").start()

    Thread({
        while (true) {
            desk.get()
        }
    }, "CUSTOMER01").start()

    Thread({
        while (true) {
            desk.get()
        }
    }, "CUSTOMER02").start()
}

fun main() {
    threadPoint01()
//    coroutinePoint01()
}