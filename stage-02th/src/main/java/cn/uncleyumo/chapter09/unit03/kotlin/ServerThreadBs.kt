package cn.uncleyumo.chapter09.unit03.kotlin

import cn.uncleyumo.utils.LogPrinter
import java.io.PrintStream
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName ServerThreadBs
 * @createDate 5/18/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class ServerThreadBs {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val serverSocket = ServerSocket(8081)
            val pool = ThreadPoolExecutor(
                16 * 2,
                16 * 2,
                0,
                TimeUnit.SECONDS,
                ArrayBlockingQueue(8),
                Executors.defaultThreadFactory(),
                ThreadPoolExecutor.AbortPolicy()
            )
            while (true) {
                val userSocket = serverSocket.accept()
                pool.execute(ServerReaderRunnable(userSocket))
            }
        }
    }
}

@Suppress("DuplicatedCode")
class ServerReaderRunnable(private val userSocket: Socket) : Runnable {
    override fun run() {
        try {
            userSocket.getOutputStream().use { ops ->
                PrintStream(ops).use { ps ->
                    val response = buildString {
                        append("HTTP/1.1 200 OK\r\n")
                        append("Content-Type: text/html; charset=utf-8\r\n")
                        append("Connection: close\r\n") // 可选，告诉客户端关闭连接
                        append("\r\n") // 空行表示头部结束
                        append("<div><h1 style=\"text-align: center;\">Hello World!</h1></div>")
                        append("<div><h1 style=\"text-align: center;color: red;\">Your IP is: ${userSocket.inetAddress.hostAddress}</h1>")
                        append("<h1 style=\"text-align: center;color: red;\">Your Port is: ${userSocket.port}</h1></div>")
                    }
                    ps.println(response)
                }
            }
        } catch (e: Exception) {
            LogPrinter.error(e.message ?: "Unknown error occurred")
        }
    }
}