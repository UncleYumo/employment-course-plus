package cn.uncleyumo.exam

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import java.util.*

@Suppress("DuplicatedCode")
fun main() {
    ColorPrinter.printlnFontGreen("------------欢迎来到库存管理系统----------")
    val inventory = Inventory()
    val scanner = Scanner(System.`in`)

    try {
        while (true) {
            ColorPrinter.printlnFontCyan("\n1.查询所有商品信息，2.商品入库，3.商品出库，4.查看指定商品库存数量，5.退出系统")
            print("请输入选项：")
            val cmd = scanner.nextLine().trim()
            when (cmd) {
                "1" -> inventory.listProducts()
                "2" -> addProduct(scanner, inventory)
                "3" -> removeProduct(scanner, inventory)
                "4" -> {
                    ColorPrinter.printFontCyan("请输入商品名称：")
                    val name = scanner.nextLine().trim()
                    val result = inventory.findProduct(name)
                    println(result)
                }
                "5" -> {
                    inventory.saveData()
                    ColorPrinter.printlnFontGreen("------------已经退出库存管理系统----------")
                    return
                }
                else -> LogPrinter.error("无效的选项，请重新输入！")
            }
        }
    } catch (e: Exception) {
        LogPrinter.error("运行错误：${e.message}")
    }
}

@Suppress("DuplicatedCode")
fun addProduct(scanner: Scanner, inventory: Inventory) {
    try {
        ColorPrinter.printlnFontCyan("------------请依次输入商品名称,价格,数量（用英文逗号隔开）----------")
        val input = scanner.nextLine().trim()
        val parts = input.split(",")
        if (parts.size != 3) throw Exception("输入格式错误，需要三个参数")

        val name = parts[0]
        val price = parts[1].toDouble()
        if (price <= 0) throw Exception("价格必须大于0")
        val count = parts[2].toInt()
        if (count <= 0) throw Exception("数量必须大于0")

        val product = Product(name, price, count)
        inventory.addProduct(product)
    } catch (e: Exception) {
        LogPrinter.error("运行错误：${e.message}")
        LogPrinter.info("是否重新输入？ y/n")
        val cmd = scanner.nextLine().trim()
        if (cmd == "y") addProduct(scanner, inventory)
    }
}

@Suppress("DuplicatedCode")
fun removeProduct(scanner: Scanner, inventory: Inventory) {
    if (inventory.countProduct() <= 0) {
        LogPrinter.error("当前库无商品，请先添加商品")
        return
    }
    try {
        ColorPrinter.printlnFontCyan("------------请依次输入商品名称,价格,数量（用英文逗号隔开）----------")
        val input = scanner.nextLine().trim()
        val parts = input.split(",")
        if (parts.size != 3) throw Exception("输入格式错误，需要三个参数")

        val name = parts[0]
        val price = parts[1].toDouble()
        val quantity = parts[2].toInt()

        inventory.reduceStock(name, price, quantity)
        ColorPrinter.printlnFontGreen("成功出库 $quantity 个 $name")
    } catch (e: RuntimeException) {
        LogPrinter.error("操作失败：${e.message}")
        LogPrinter.info("是否重新输入？ y/n")
        val cmd = scanner.nextLine().trim()
        if (cmd == "y") removeProduct(scanner, inventory)
    }
}