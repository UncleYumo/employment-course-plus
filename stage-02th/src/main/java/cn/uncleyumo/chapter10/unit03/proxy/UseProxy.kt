package cn.uncleyumo.chapter10.unit03.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName UseProxy
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

data class BigStar(val name: String): Star {
    override fun sing(songName: String): String {
        println("$name is singing $songName")
        return "Thank you!"
    }
    override fun dance(danceName: String): String {
        println("$name is dancing $danceName")
        return "Thank you!"
    }
}

interface Star {
    fun sing(songName: String): String
    fun dance(danceName: String): String
}

class ProxyUtil {
    companion object {
        fun createProxy(bigStar: BigStar): Star = Proxy.newProxyInstance(
            ProxyUtil::class.java.classLoader,
            arrayOf(Star::class.java)
        ) { _, method, args ->
            when (method.name) {
                "sing" -> {
                    println("Proxy is singing")
                }

                "dance" -> {
                    println("Proxy is dancing")
                }

                else -> {
                    println("Proxy is doing something")
                    throw IllegalArgumentException("No such method")
                }
            }
            method.invoke(bigStar, *args)
        } as Star
    }
}

fun main() {
    val bigStar = BigStar("Taylor Swift")
    val proxy = ProxyUtil.createProxy(bigStar)
    println(proxy.sing("Shape of You"))
    println(proxy.dance("Tango"))
    println(proxy.dance("Waltz"))
}

fun testVarArgs() {
    test("Hello", "World", "Java", "Kotlin")
    test(*arrayOf("Hello", "World", "Java", "Kotlin"))
    test("Hello", "World")
    val strings = arrayOf("Hello", "World")
    test(*strings)
}

fun test(vararg args: String) {
    println(args.joinToString())
}