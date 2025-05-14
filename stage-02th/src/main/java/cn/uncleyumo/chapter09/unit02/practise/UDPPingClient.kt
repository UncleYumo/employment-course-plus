package cn.uncleyumo.chapter09.unit02.practise

import cn.uncleyumo.utils.LogPrinter
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.UUID

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName UDPPingClient
 * @createDate 5/14/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class UDPPingClient(
    host: String = "dev.uncleyumo.cn",
    private val port: Int = 8081
) {
    private val socket = DatagramSocket()
    private val address = InetAddress.getByName(host)
    private val interval = 1000L
    fun startPing() {
        for (i in 1..10) {
            logTime(i) { sendPing() }
            Thread.sleep(interval)
        }
    }
    private fun sendPing() : String {
        val msgToBeSent = UUID.randomUUID().toString().substring(0, 8)
        val packet = DatagramPacket(
            msgToBeSent.toByteArray(),
            msgToBeSent.length,
            address,
            port
        )
        socket.send(packet)

        // receive response
        val buffer = ByteArray(1024 * 64)
        val responsePacket = DatagramPacket(buffer, buffer.size)
        socket.receive(responsePacket)
        return "${msgToBeSent}|${String(buffer, 0, responsePacket.length)}"
    }
    private fun logTime(i: Int, func: () -> String) : Unit {
        val start = System.currentTimeMillis()
        val msg = func()
        val end = System.currentTimeMillis()
        val split = msg.split("|")
        LogPrinter.info("Ping($i) ${split[0]} \t PING ${split[1]} ${end - start}ms")
    }
}

fun main() {
    UDPPingClient().startPing()
}