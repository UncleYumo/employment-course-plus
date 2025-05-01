package cn.uncleyumo.chapter07.unit02.kotlin

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.Exception

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TestLog4j
 * @createDate 5/1/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

val LOGGER: Logger = LoggerFactory.getLogger("")

fun main() {
    practise01();
}

fun practise01() {
    try {
        LOGGER.info("Main Method is running.")
        division(1, 10)
        LOGGER.info("Main Method is completed.")
    } catch (e: Exception) {
        LOGGER.error(e.message)
    }
}

fun division(a: Int, b: Int): Int {
    LOGGER.debug("The division method is running.")
    val c = a / b
    println("The division method result is $c")
    LOGGER.debug("The division method is completed.")
    return c
}