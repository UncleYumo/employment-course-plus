package cn.uncleyumo.chapter09.unit02.practise

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.Socket

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TCPQQClient
 * @createDate 5/14/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class TCPQQClient(
    host: String = "127.0.0.1",
    port: Int = 8081
) {
    private val socket = Socket(host, port)
    fun startClient() {
        LogPrinter.warn("TCPQQClient startClient")
        val ips = socket.getInputStream()
        val ops = socket.getOutputStream()
        val dis = DataInputStream(ips)
        val dos = DataOutputStream(ops)
        var cmd = ""
        while (cmd !in listOf("exit", "quit", ":wq")) {
            ColorPrinter.printFontGreen(">> ")
            cmd = readlnOrNull() ?: ""
            if (cmd.isNotBlank()) {
                dos.writeUTF(cmd)
                dos.flush()
                LogPrinter.info("CallBack: ${dis.readUTF()}")
            }
        }
        dis.close()
        dos.close()
        ops.close()
        ips.close()
        socket.close()
        LogPrinter.warn("TCPQQClient stopClient")
    }
}

fun main() {
    TCPQQClient().startClient()
}