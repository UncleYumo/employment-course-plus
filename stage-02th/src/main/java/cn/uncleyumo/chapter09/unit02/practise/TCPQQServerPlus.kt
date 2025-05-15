package cn.uncleyumo.chapter09.unit02.practise

import cn.uncleyumo.utils.LogPrinter
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket
import java.sql.Time

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TCPQQServerPlus
 * @createDate 5/15/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@Suppress("DuplicatedCode")
class TCPQQServerPlus(port: Int = 8081) {
    private val serverSocket = ServerSocket(port)
    companion object { var count = 0 }
    fun startServer() {
        while (true) {
            LogPrinter.run {
                warn("[${serverSocket.inetAddress.hostAddress}:${serverSocket.localPort}] waiting for connection")
                val socket = serverSocket.accept()
                ServerReaderThread(socket).start()
                warn("[${socket.inetAddress.hostAddress}:${socket.port}] connected")
                count++
                debug("current online count: $count")
            }
        }
    }
}

class ServerReaderThread(private val socket: Socket): Thread() {
    override fun run() {
        try {
            val inputStream = socket.getInputStream()
            val outputStream = socket.getOutputStream()

            DataInputStream(inputStream).use { dips ->
                DataOutputStream(outputStream).use { dops ->
                    while (true) {
                        val msg = dips.readUTF()
                        LogPrinter.info("[${socket.inetAddress.hostAddress}:${socket.port}] $msg")

                        // 回应客户端
                        val response = "Server received: ${msg + System.currentTimeMillis()}"
                        dops.writeUTF(response)
                        dops.flush()
                    }
                }
            }
        } catch (e: Exception) {
            LogPrinter.run {
                error("[Client ]${socket.inetAddress.hostAddress}:${socket.port}] disconnected")
                TCPQQServerPlus.count--
                debug("current online count: ${TCPQQServerPlus.count}")
            }
        } finally {
            socket.close()
        }
    }
}

fun main() {
    TCPQQServerPlus().startServer()
}

