package cn.uncleyumo.chapter09.unit02.kotlin

import cn.uncleyumo.utils.ColorPrinter
import java.io.DataOutputStream
import java.net.Socket
import kotlin.system.exitProcess

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TCPClient
 * @createDate 5/14/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class TCPClient(
    host: String,
    port: Int
) {
    private val socket = Socket(host, port)
    fun startClient() {
        ColorPrinter.printlnFontYellow("TCP Client Start...")
        val os = socket.getOutputStream()
        val dos = DataOutputStream(os)
        var cmd = ""
        while (cmd !in listOf("exit", "quit", "bye", ":wq", ":q")) {
            ColorPrinter.printFontGreen(">> ")
            cmd = readlnOrNull() ?: ""
            if (cmd.isNotBlank()) {
                dos.writeUTF(cmd)
                dos.flush()
            }
            if (cmd == "break") {
                dos.close()
                os.close()
                socket.close()
                // Exit Program
                exitProcess(0)
            }
        }
        dos.writeUTF("!quit")
        dos.flush()
        dos.close()
        os.close()
        ColorPrinter.printlnFontYellow("TCP Client End...")
    }
}

fun main() {
    TCPClient(
        "dev.uncleyumo.cn",
        8081
    ).startClient()
}