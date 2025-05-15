package cn.uncleyumo.chapter09.unit03.kotlin

import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.*
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.InetAddress
import java.net.Socket

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName GroupChatClient
 * @createDate 5/15/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class GroupChatClient(
    host: String = "dev.uncleyumo.cn",
    port: Int = 8081
) {
    private val socket = Socket(InetAddress.getByName(host), port)
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    fun start() = runBlocking {
        LogPrinter.warn("----------客户端启动成功----------")
        val dops = DataOutputStream(socket.getOutputStream())
        val dips = DataInputStream(socket.getInputStream())
        scope.launch {
            while (true) {
                LogPrinter.info("[服务端] ${dips.readUTF()}")
            }
        }
        val cmd = ""
        while (cmd !in listOf("exit", "quit", "bye", ":q", ":wq")) {
            val msg = readlnOrNull() ?: continue
            if (msg.isNotBlank()) {
                dops.writeUTF(msg)
                dops.flush()
            }
        }
        scope.cancel()
        socket.close()
        LogPrinter.warn("----------客户端已退出----------")
    }
}

fun main() {
    GroupChatClient().start()
}