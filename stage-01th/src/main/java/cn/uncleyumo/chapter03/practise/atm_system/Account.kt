package cn.uncleyumo.chapter03.practise.atm_system

import java.lang.reflect.Constructor
import kotlin.math.sign

/**
 * @author uncle_yumo
 * @fileName Account
 * @createDate 2025/4/8 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

data class Account(
    var cardId: String? = null,
    var userName: String? = null,
    var sex: Char? = null,
    var passWord: String? = null,
    var money: Double? = null,
    var limit: Double? = null
) {
    private fun getFormattedUserName(): String? {
        if (userName == null || sex == null) return null
        return userName + if (sex == '男') "先生" else "女士"
    }

    fun showInfo() {
        println("""
            欢迎您：${getFormattedUserName()}
            卡号：$cardId
            密码：$passWord
            余额：$money
            限额：$limit
        """.trimIndent() + "\n")
    }
}