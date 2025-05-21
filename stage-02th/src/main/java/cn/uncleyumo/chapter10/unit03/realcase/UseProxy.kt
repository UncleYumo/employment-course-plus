package cn.uncleyumo.chapter10.unit03.realcase

import java.lang.reflect.Proxy

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName UseProxy
 * @createDate 5/21/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

interface UserService {
    fun login(username: String, password: String)
    fun deleteUsers()
    fun selectUsers(): Array<String>
}

class UserServiceImpl : UserService {
    override fun login(username: String, password: String) {
//        val startTime = System.currentTimeMillis()
        if ((username == "dev" && password == "dev").not()) {
            println("用户名或密码错误")
            Thread.sleep(500L)
//            println("登录耗时：${System.currentTimeMillis() - startTime}ms")
            return
        }
        Thread.sleep(1000L)
        println("登录成功，欢迎您 $username!")
//        println("登录耗时：${System.currentTimeMillis() - startTime}ms")
    }

    override fun deleteUsers() {
//        val startTime = System.currentTimeMillis()
        Thread.sleep(500L)
        println("成功删除了一万个用户")
//        println("删除用户耗时：${System.currentTimeMillis() - startTime}ms")
    }

    override fun selectUsers(): Array<String> {
//        val startTime = System.currentTimeMillis()
        val users = arrayOf("dev", "dev1", "dev2", "dev3", "dev4", "dev5", "dev6", "dev7", "dev8", "dev9", "dev10")
        Thread.sleep(500L)
        println("成功查询了 ${users.size} 个用户")
//        println("查询用户耗时：${System.currentTimeMillis() - startTime}ms")
        return users
    }
}

class ProxyUtil {
    companion object {
        fun createProxy(userService: UserService) : UserService {
            return Proxy.newProxyInstance(
                UserService::class.java.classLoader,
                arrayOf(UserService::class.java)
            ) { _, method, args ->
                var result: Any? = null
                if (method.name in arrayOf("login", "deleteUsers", "selectUsers")) {
                    val startTime = System.currentTimeMillis()
                    result = method.invoke(userService, *(args ?: emptyArray()))
                    println("${method.name}耗时：${System.currentTimeMillis() - startTime}ms")
                } else {
                    result = method.invoke(userService, *(args ?: emptyArray()))
                }
                result
            } as UserService
        }
    }
}

fun main() {
    val userService = UserServiceImpl()
    val proxy = ProxyUtil.createProxy(userService)
    proxy.login("dev", "dev")
    proxy.deleteUsers()
    proxy.selectUsers()
}