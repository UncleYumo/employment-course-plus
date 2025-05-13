package cn.uncleyumo.chapter09.unit02.kotlin

import cn.uncleyumo.utils.LogPrinter
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName UDPServer
 * @createDate 5/13/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class UDPServer(
    port: Int = getPortOfLocalhost()
) {
    // listen all port and 0.0.0.0
    private val socket = DatagramSocket(port)
    init {
        LogPrinter.info("Server\tstart at port: $port")
    }
    fun receiveData() {
        val buffer = ByteArray(1024 * 64)
        val packet = DatagramPacket(buffer, buffer.size)
        LogPrinter.info("Server\t waiting for receive data...")
        socket.receive(packet)
        LogPrinter.info("Server\t receive(${packet.address}:${packet.port}): ${String(packet.data,  0, packet.length)}")
    }
}

fun main() {
    val udpServer = UDPServer()
    var count = 0
    while (true) {
        LogPrinter.info("Server\t receive count: $count")
        udpServer.receiveData()
        count++
    }
}