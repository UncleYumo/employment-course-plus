package cn.uncleyumo.chapter09.unit02.practise

import cn.uncleyumo.utils.LogPrinter
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName UDPPingServer
 * @createDate 5/14/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class UDPPingServer(private val port: Int = 8081) {
    private val socket = DatagramSocket(port)

    fun startServer() {
        LogPrinter.info("UDPPingServer is listening on port $port...")
        while (true) {
            // 创建接收数据包的缓冲区
            val buffer = ByteArray(1024 * 64)
            val packet = DatagramPacket(buffer, buffer.size)

            // 接收数据包
            socket.receive(packet)

            // 获取客户端信息
            val receivedData = String(packet.data, 0, packet.length)
            val clientAddress: InetAddress = packet.address
            val clientPort: Int = packet.port

            // 打印接收到的信息
            LogPrinter.info("Received message: '$receivedData' from $clientAddress:$clientPort")

            // 转换消息为大写
            val responseMessage = receivedData.toUpperCase()

            // 发送响应给客户端
            val responsePacket = DatagramPacket(
                responseMessage.toByteArray(),
                responseMessage.length,
                clientAddress,
                clientPort
            )
            socket.send(responsePacket)
        }
    }
}

fun main() {
    UDPPingServer().startServer()
}
