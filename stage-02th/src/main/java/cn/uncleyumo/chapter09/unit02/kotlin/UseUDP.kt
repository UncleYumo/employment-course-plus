package cn.uncleyumo.chapter09.unit02.kotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName UseUDP
 * @createDate 5/13/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun main() {
//    testUDP()  // The function is shit !!!
    UDPClient().sendDataByUserInput()
}

// Use coroutine to send and receive data
fun testUDP() = runBlocking {
    launch {
        UDPServer().receiveData()
    }
    launch {
        delay(1000L)
        UDPClient().sendData()
    }
}

fun getDnsAddressOfLocalhost() = "dev.uncleyumo.cn"
fun getPortOfLocalhost() = 8082