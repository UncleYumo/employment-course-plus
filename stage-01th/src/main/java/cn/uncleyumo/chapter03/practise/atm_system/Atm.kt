package cn.uncleyumo.chapter03.practise.atm_system

import java.time.LocalDateTime
import java.util.Scanner
import kotlin.random.Random

/**
 * @author uncle_yumo
 * @fileName ATM
 * @createDate 2025/4/8 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

private val accounts: MutableList<Account> = mutableListOf()

/** 启动ATM系统，展示欢迎界面 */
tailrec fun start() {
    println("""
        ===欢迎您进入ATM系统===
        1、用户登录
        2、用户开户
        3、用户退出
        请输入您的选择：
    """.trimIndent())
    val command = readlnOrNull() ?: "unknown"
    when (command) {
        "1" -> {
            login()
            start()
        }
        "2" -> {
            openAccount()
            start()
        }
        "3" -> {
            println("===用户退出===")
            return
        }
        else -> {
            println("输入错误，请重新输入！")
            start()
        }
    }
}

/** 用户开户 */
private fun openAccount() {
    println("===用户开户===")
    accounts.add(Account().apply {
        println("请输入您的账户名称：")
        this.userName = readlnOrNull() ?: LocalDateTime.now().toString()
        while (true) {
            println("请输入您的性别：")
            val sex = readlnOrNull()?.first()
            if (sex in '男' downTo '女') {
                this.sex = sex
                break
            } else {
                println("性别输入错误，请重新输入！")
            }
        }
        while (true) {
            println("请输入您的密码：")
            val password = readlnOrNull()
            println("请再次输入您的密码：")
            val password2 = readlnOrNull()
            if (password == password2) {
                this.passWord = password
                break
            } else {
                println("两次密码输入不一致，请重新输入！")
            }
        }
        cardId = getUniqueCardId()
        println("请输入您的取现额度：")
        this.limit = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        println("恭喜${userName}，您已成功开户，卡号：$cardId\n")
    })
}

/** 获取唯一的卡号 */
fun getUniqueCardId(): String {
    val random = Random(System.currentTimeMillis())
    var cardId = ""
    for (i in 1..8) cardId += random.nextInt(10)
    return if (accounts.any { it.cardId == cardId }) getUniqueCardId() else cardId
}

/** 用户登录 */
private fun login() {
    println("===用户登录===")
    if (accounts.isEmpty()) {
        println("当前系统没有用户，请先注册！\n")
        return
    }

    while (true) {
        print("请输入您的卡号：")
        val cardId = readlnOrNull() ?: continue

        val account = accounts.find { it.cardId == cardId }
        if (account == null) {
            println("卡号不存在，请重新输入！\n")
            continue
        }

        print("请输入您的密码：")
        val password = readlnOrNull() ?: continue

        if (account.passWord == password) {
            println("登录成功！\n")
            account.showInfo()
            return
        } else {
            println("密码错误，请重新输入！\n")
        }
    }
}
