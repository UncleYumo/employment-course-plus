package cn.uncleyumo.chapter08.unit01.kotlin

import cn.uncleyumo.utils.ColorPrinter
import kotlinx.coroutines.*
import java.util.UUID

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName LearnSuspend
 * @createDate 5/3/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

data class User(var username: String? = null, var password: String? = null)

suspend fun getCurrentUser(): User {
    delay(1000L)  // simulate a net io operation
    return User().also { it.username = "dev.uncleyumo.cn"; it.password = UUID.randomUUID().toString().substring(0, 8) }
}

suspend fun getUserByUsername(username: String): User {
    delay(1000L)  // simulate a net io operation
    return User().also { it.username = username; it.password = UUID.randomUUID().toString().substring(0, 8) }
}

fun entry() = runBlocking {
    ColorPrinter.printlnFontCyan("Start to do IO operation...")
    var user: User
    launch(Dispatchers.IO) {
        user = getCurrentUser()
        ColorPrinter.printlnFontGreen("Get current user: $user")
    }
    launch {
        val userByUsername = getUserByUsername("uncleyumo")
        ColorPrinter.printlnFontGreen("Get user by username: $userByUsername")
    }
}

fun entry2() = runBlocking {
    ColorPrinter.printlnFontCyan("Start to do IO operation...")
    val user = async { getCurrentUser() }
    val userByUsername = async { getUserByUsername("uncleyumo") }
    ColorPrinter.printlnFontGreen("Get user by username: ${userByUsername.await()}")
    ColorPrinter.printlnFontGreen("Get current user: ${user.await()}")
    ColorPrinter.printlnFontGreen("Done")
}

fun main() {
    entry2()
    ColorPrinter.printlnFontRed("Done")
}