package cn.uncleyumo.chapter09.unit02.practise

import cn.uncleyumo.utils.LogPrinter
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import javax.sound.sampled.Port

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TCPQQServer
 * @createDate 5/14/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class TCPQQServer(port: Int = 8081) {
    private val serverSocket = ServerSocket(port)
    fun startServer() {
        LogPrinter.info("Server started")
        val socket = serverSocket.accept()
        val ops = socket.getOutputStream()
        val dos = DataOutputStream(ops)
        val ips = socket.getInputStream()
        val dis = DataInputStream(ips)
        try {
            while (true) {
                val message = dis.readUTF()
                LogPrinter.info("Received message: $message")
                dos.writeUTF("你好，我现在有事不在，请稍后联系")
                dos.flush()
            }
        } catch (e: Exception) {
            LogPrinter.error("Client might be disconnected")
        }
        dos.close()
        ops.close()
        dis.close()
        ips.close()
        serverSocket.close()
        LogPrinter.warn("Server stopped")
    }
}

fun main() {
    TCPQQServer().startServer()
}