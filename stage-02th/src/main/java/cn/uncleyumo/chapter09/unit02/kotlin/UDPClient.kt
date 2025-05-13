package cn.uncleyumo.chapter09.unit02.kotlin

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.UUID

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName UDPClient
 * @createDate 5/13/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class UDPClient(
    private val socket: DatagramSocket = DatagramSocket(),
    private val port: Int = getPortOfLocalhost(),
    private val address: InetAddress = InetAddress.getByName(getDnsAddressOfLocalhost()),
) {
    init {
        LogPrinter.info("Client\tcreated")
    }
    fun sendData(data: String = "Empty Data") {
        // create data packet to package data
        val packet = DatagramPacket(
            data.toByteArray(),
            data.toByteArray().size,
            address,
            port
        )
        LogPrinter.info("Client\tSend data to ${packet.address}:${packet.port}")
        socket.send(packet)
        LogPrinter.info("Client\tSend data success")
    }
    fun sendDataByUserInput() {
        var command = ""
        while (true) {
            ColorPrinter.printFontCyan(">> ")
            command = readlnOrNull() ?: "null"
            when (command) {
                "exit", ":wq" -> {
                    LogPrinter.info("Client\tExit")
                    break
                }
                else -> {
                    sendData(command)
                }
            }
        }
        socket.close()
        LogPrinter.info("Client\tClose")
    }
}

fun main() {
    val udpClient = UDPClient()
    while (true) {
        Thread.sleep(3000L)
        udpClient.sendData(UUID.randomUUID().toString().substring(0, 8))
    }
}