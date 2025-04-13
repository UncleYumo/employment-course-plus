package cn.uncleyumo.chapter03.kotlin

/**
 * @author uncle_yumo
 * @fileName Test02
 * @createDate 2025/4/7 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

fun main() {
    FoodManage().start()
}

fun verificationCode() {
    val randomCode = getRandomCode(6)
    println(randomCode)
    println("请输入验证码：")
    val inputCode = readlnOrNull() ?: println("验证码不能为空！")
    if (inputCode == randomCode) {
        println("验证码正确！")
    }
}

fun getRandomCode(len: Int): String {
    var code = ""
    val data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    for (i in 0 until len) {
        // 随机获取一个字符
        val index = data.indices.random()
        code += data[index]
    }
    return code
}

fun exampleUserLogin() {
    for (i in 1..3) {
        println("请输入登录名称：")
        val name = readlnOrNull() ?: "Unknown"
        println("请输入密码：")
        val password = readlnOrNull() ?: "Unknown"
        if (login(name, password)) {
            println("登录成功！")
            break
        } else {
            println("登录失败，请重试！")
        }
    }
}

fun login(name: String, password: String): Boolean {
    val okLoginName = "itheima"
    val okLoginPassword = "123456"
    return name == okLoginName && password == okLoginPassword
}