package cn.uncleyumo.chapter09.unit03.kotlin

import cn.uncleyumo.utils.LogPrinter
import kotlinx.coroutines.*
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ConcurrentHashMap
import kotlin.random.Random

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName GroupChatServer
 * @createDate 5/15/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description 群聊服务器
 */

class GroupChatServer(port: Int = 8081) {
    private val server = ServerSocket(port)
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    companion object {
        val onlineSockets = ConcurrentHashMap<String, Socket>()

        @JvmStatic
        fun main(args: Array<String>) {
            GroupChatServer().start()
        }
    }

    fun start() = runBlocking {
        LogPrinter.warn("----------服务器启动成功----------")
        while (true) {
            val socket = server.accept()
            if (socket.isConnected) {
                handleClientConnection(socket)
            }
        }
    }

    private fun handleClientConnection(socket: Socket) {
        scope.launch {
            try {
                val randomName = generateUniqueUsername()
                onlineSockets[randomName] = socket
                LogPrinter.info("[${socket.inetAddress.hostAddress}:${socket.port}] $randomName 加入聊天室，当前在线人数：${onlineSockets.size}")

                val dips = DataInputStream(socket.getInputStream())
                val dops = DataOutputStream(socket.getOutputStream())
                dops.writeUTF("欢迎 $randomName 进入聊天室，当前在线人数：${onlineSockets.size}")
                dops.flush()
                try {
                    while (socket.isConnected && !socket.isClosed) {
                        val message = dips.readUTF()
                        handleMessage(message, randomName, dops)
                    }
                } catch (e: Exception) {
                    LogPrinter.error("${socket.inetAddress.hostAddress}:${socket.port} 已断开连接")
                } finally {
                    dips.close()
                    dops.close()
                    onlineSockets.remove(randomName)
                    LogPrinter.info("$randomName 已退出，当前在线人数：${onlineSockets.size}")
                }
            } catch (e: Exception) {
                LogPrinter.error("客户端连接处理失败: ${e.message}")
            }
        }
    }

    private fun generateUniqueUsername(): String {
        var name: String
        do {
            name = "user${Random.nextInt(100, 999)}"
        } while (onlineSockets.containsKey(name))
        return name
    }

    private suspend fun handleMessage(
        message: String,
        senderName: String,
        dops: DataOutputStream
    ) {
        val parts = message.split(":")
        if (parts.size < 2) {
            withContext(Dispatchers.IO) {
                dops.writeUTF("请输入合法的消息格式(user:message)")
            }
            return
        }

        val targetUser = parts[0]
        val content = parts[1]

        if (targetUser.isBlank() || content.isBlank()) {
            withContext(Dispatchers.IO) {
                dops.writeUTF("请输入合法的消息格式(user:message)")
            }
            return
        }

        if (targetUser == "all") {
            if (content == "ls") {
                withContext(Dispatchers.IO) {
                    dops.writeUTF(
                        "当前在线用户：${onlineSockets.keys.joinToString(", ")}"
                    )
                }
                return
            }
            sendMsgToAll("$senderName say to all: $content")
        } else {
            val targetSocket = onlineSockets[targetUser]
            if (targetSocket != null && targetSocket.isConnected && !targetSocket.isClosed) {
                withContext(Dispatchers.IO) {
                    dops.writeUTF("$senderName say to $targetUser: $content")
                    onlineSockets[targetUser]?.let {
                        val targetDops = DataOutputStream(it.getOutputStream())
                        targetDops.writeUTF("$senderName say to you: $content")
                    }
                }
            } else {
                withContext(Dispatchers.IO) {
                    dops.writeUTF("找不到用户：$targetUser")
                }
            }
        }
    }

    private fun sendMsgToAll(msg: String) {
        onlineSockets.forEach { (_, socket) ->
            if (socket.isConnected && !socket.isClosed) {
                try {
                    val dops = DataOutputStream(socket.getOutputStream())
                    dops.writeUTF(msg)
                } catch (e: Exception) {
                    LogPrinter.error("发送消息失败: ${e.message}")
                }
            }
        }
    }
}