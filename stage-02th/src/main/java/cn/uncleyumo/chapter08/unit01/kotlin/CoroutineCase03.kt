package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import java.util.UUID
import kotlin.random.Random

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName CoroutineCase03
 * @createDate 5/3/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

suspend fun generateMessage(channel: Channel<String>) {
    try {
        var i = 1
        while (true) {
            if (i % 5 == 0) {
                channel.send("stop")
                i++
                continue
            }
            val msg = "Message from generateMessage() ${UUID.randomUUID().toString().substring(0, 8)}"
            channel.send(msg)
            ColorPrinter.printlnFontWhite("Message sent: $msg")
            delay(Random.nextLong(800L, 1000L))
            i++
        }
    } catch (e: Exception) {
        LogPrinter.error(e.message ?: "No Error Message Received")
    }
}

suspend fun consumeMessage(channel: Channel<String>, job: Job): String {
    while (true) {
        val message = channel.receive()
        ColorPrinter.printlnFontGreen("Message received: $message")
        if (message == "stop") {
            channel.close()
            job.cancel()
            job.join()
            return "stop"
        }
        delay(Random.nextLong(800L, 1000L))
    }
}

fun main() = runBlocking {
    LogPrinter.info("main start")
    val channel = Channel<String>(10)
    val gmJob = launch {
        generateMessage(channel)
    }
    val cmJob = async {
        consumeMessage(channel, gmJob)
    }
    LogPrinter.info(cmJob.await())
    LogPrinter.info("main end")
}