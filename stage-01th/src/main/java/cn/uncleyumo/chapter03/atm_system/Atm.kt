package cn.uncleyumo.chapter03.atm_system

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
private var currentAccount: Account? = null

/** 启动ATM系统，展示欢迎界面 */
tailrec fun start() {
//    accounts.add(Account(userName = "123", passWord = "123", cardId = "123", limit = 1000000.0, sex = '男', money = 100.0))
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
        println("请输入您的取现额度：")
        limit = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        println("请输入您的余额：")
        money = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        cardId = getUniqueCardId()
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
            currentAccount = account
            showUserCommand()
            break
        } else {
            println("密码错误，请重新输入！\n")
        }
    }
}

private fun showUserCommand() {
    while (true) {
        println("""
        ===${currentAccount?.getFormattedUserName()}，您可以选择如下功能进行账户的处理===
        1、查询账户
        2、存款
        3、取款
        4、转账
        5、修改密码
        6、退出
        7、注销当前账户
        请输入您的选择：
    """.trimIndent())
        val command = readlnOrNull() ?: "unknown"
        when (command) {
            "1" -> {
                // 查询账户信息
                println("===查询账户===")
                currentAccount?.showInfo()
            }
            "2" -> {
                // 存款
                depositMoney()
            }
            "3" -> {
                // 取款
                withdrawMoney()
            }
            "4" -> {
                // 转账
                transferMoney()
            }
            "5" -> {
                // 修改密码
                println("===修改密码===")
                updatePassword()
                return
            }
            "6" -> {
                // 退出
                println("===用户退出===")
                println("${currentAccount?.getFormattedUserName()}已退出系统！")
                currentAccount = null
                return
            }
            "7" -> {
                // 注销账户
                if (deleteAccount()) {
                    return
                }
            }
        }
    }
}

/** 修改密码 */
fun updatePassword() {
    println("===修改密码===")
    while (true) {
        print("请输入您的原密码：")
        val oldPassword = readlnOrNull()

        if (oldPassword.isNullOrBlank()) {
            println("密码不能为空！")
            continue
        }

        if (currentAccount?.passWord == oldPassword) {
            print("请输入您的新密码：")
            val newPassword = readlnOrNull()

            if (newPassword.isNullOrBlank()) {
                println("密码不能为空！")
                continue
            }

            println("请再次输入您的新密码：")
            val newPassword2 = readlnOrNull()

            if (newPassword2.isNullOrBlank()) {
                println("密码不能为空！")
                continue
            }

            if (newPassword != newPassword2) {
                println("两次密码输入不一致，请重新输入！")
                continue
            }

            currentAccount?.passWord = newPassword
            println("恭喜您，密码修改成功！")
            return
        } else {
            println("密码错误，请重新输入！")
            continue
        }
    }
}

/** 删除账户 */
fun deleteAccount(): Boolean {
    println(
        """
                    您确定要注销账户吗？
                    1、确认注销
                    2、取消操作
                """.trimIndent()
    )
    val confirm = readlnOrNull() ?: "unknown"
    return if (confirm == "1") {
        // 判断用户账户中是否有余额
        if (currentAccount?.money!! > 0.0) {
            println("您的账户中有余额，无法注销！")
            false
        } else {
            accounts.remove(currentAccount)
            println("您的账户已注销！")
            currentAccount = null
            true
        }
    } else {
        println("操作已取消！")
        false
    }
}

/** 转账 */
fun transferMoney() {
    println("===转账===")
    // 判断系统中是否存在其他账户
    if (accounts.size < 2) {
        println("当前系统没有其他账户，无法转账！")
        return
    }

    // 判断当前账户余额是否足够（假设至少需要100元才能转账）
    if (currentAccount?.money!! < 100.0) {
        println("您的余额不足100元，无法转账！")
        return
    }

    println("请输入您要转账的卡号：")
    val cardId = readlnOrNull()?.trim()
    if (cardId.isNullOrBlank()) {
        println("卡号不能为空！")
        return
    }

    // 查找目标账户
    val targetAccount = accounts.find { it.cardId == cardId }
    if (targetAccount == null) {
        println("卡号不存在，请重新输入！")
        return
    }

    // 检查是否向自己转账
    if (targetAccount == currentAccount) {
        println("不能转账给自己！")
        return
    }

    while (true) {
        println("请验证对方账户名姓氏：")
        val preName = readlnOrNull()?.trim()
        if (preName.isNullOrBlank()) {
            println("姓名不能为空！")
            continue
        }

        // 检查姓氏是否匹配，这里假设用户名至少有一个字符，并且只验证第一个字符
        if (preName[0] != targetAccount.userName?.firstOrNull()) {
            println("姓氏不匹配，请重新输入！")
            continue
        }
        break
    }

    while (true) {
        println("请输入您要转账的金额：")
        val money = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        if (money <= 0.0) {
            println("转账金额必须大于0元！")
            continue
        }

        if (money > currentAccount?.money!!) {
            println("您的余额不足，无法转账！")
            continue
        }

        // 执行转账操作
        currentAccount?.money = currentAccount?.money?.minus(money)
        targetAccount.money = targetAccount.money?.plus(money)
        println("您成功转账${money}元，您当前的余额为：${currentAccount?.money}元！")
        return
    }
}

/** 取款 */
fun withdrawMoney() {
    println("===取款===")
    // 100元起提现
    if (currentAccount?.money!! < 100.0) {
        println("您的余额不足100元，无法取款！")
        return
    }
    println("请输入您要取出的金额：")
    val money = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    if (money > (currentAccount?.money ?: 0.0)) {
        println("您的余额不足，无法取款！")
        return
    }
    currentAccount?.money = currentAccount?.money?.minus(money)
    println("恭喜您成功取出${money}元！当前余额为：${currentAccount?.money}元！")
}

/** 存款 */
fun depositMoney() {
    println("===存款===")
    println("请输入您要存入的金额：")
    val money = readlnOrNull()?.toDoubleOrNull() ?: 0.0
    currentAccount?.money = currentAccount?.money?.plus(money)
    println("恭喜您成功存入${money}元！当前余额为：${currentAccount?.money}元！")
}
