package cn.uncleyumo.chapter09.unit03.kotlin

import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName ServerBS
 * @createDate 5/17/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@Suppress("HttpUrlsUsage")
class ServerBS(port: Int = 8081) {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val server = ServerSocket(port)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ServerBS().startServer()
        }
    }

    fun startServer() {
        try {
            LogPrinter.warn("----------ServerBS Start----------")
            LogPrinter.warn("ServerBS is running on localhost:${server.localPort}")
            LogPrinter.warn("You can browse http://dev.uncleyumo.cn:${server.localPort}/ to test")
            while (true) {
                val userSocket = server.accept()
                LogPrinter.warn("ServerBS accept a new user -> ${userSocket.inetAddress.hostAddress}:${userSocket.port}")
                scope.launch {
                    userRun(userSocket)
                }
            }
        } catch (e: Exception) {
            LogPrinter.error("ServerBS error occurred:${e.message}")
        }
        LogPrinter.warn("----------ServerBS Stop-----------")
    }

private fun userRun(userSocket: Socket) {
    try {
        userSocket.getOutputStream().use { ops ->
            val response = buildString {
                append("HTTP/1.1 200 OK\r\n")
                append("Content-Type: text/html; charset=utf-8\r\n")
                append("Connection: close\r\n") // 可选，告诉客户端关闭连接
                append("\r\n") // 空行表示头部结束
                append("<div><h1 style=\"text-align: center;\">Hello World!</h1></div>")
                append("<div><h1 style=\"text-align: center;color: red;\">Your IP is: ${userSocket.inetAddress.hostAddress}</h1>")
                append("<h1 style=\"text-align: center;color: red;\">Your Port is: ${userSocket.port}</h1></div>")
                append("<div><h1 style=\"text-align: center;color: red;\">ServerBS is running on localhost:${server.localPort}</h1>")
                append("<h1 style=\"text-align: center;color: red;\">You can browse http://dev.uncleyumo.cn:${server.localPort}/ to test</h1></div>")
            }

            ops.write(response.toByteArray(Charsets.UTF_8))
            ops.flush()
        }
    } catch (e: Exception) {
        LogPrinter.error("${userSocket.inetAddress.hostAddress}:${userSocket.port} may be disconnected")
    }
}

}