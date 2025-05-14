package cn.uncleyumo.chapter09.unit02.kotlin

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import java.io.DataInputStream
import java.net.ServerSocket

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TCPServer
 * @createDate 5/14/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class TCPServer(
    port: Int = 8081
) {
    private val serverSocket = ServerSocket(port)
    fun startServer() {
        ColorPrinter.printlnFontCyan("Server start at ${serverSocket.localSocketAddress}")
        val socket = serverSocket.accept()
        val ips = socket.getInputStream()
        val dis = DataInputStream(ips)
        try {
            while (true) {
                val data = dis.readUTF()
                ColorPrinter.printlnFontCyan(
                    "Server receive: $data(${socket.remoteSocketAddress})"
                )
                if (data == "!quit") break
            }
        } catch (e: Exception) {
            LogPrinter.error("Client might be closed!")
        }
        dis.close()
        socket.close()
        ColorPrinter.printlnFontCyan("Server close")
    }
}

fun main() {
    TCPServer().startServer()
}