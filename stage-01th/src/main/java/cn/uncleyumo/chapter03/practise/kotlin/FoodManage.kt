package cn.uncleyumo.chapter03.practise.kotlin

/**
 * @author uncle_yumo
 * @fileName FoodManage
 * @createDate 2025/4/7 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

class FoodManage {
    private val foods: ArrayList<Food> = ArrayList()

    fun start() {
        while (true) {
            println("""
            ===欢迎进入商家管理系统===
               1. 上架菜品（add）
               2. 浏览菜品（query）
            请选择您的操作命令：
        """.trimIndent())
            when(readlnOrNull() ?: "null") {
                "add" -> addFood()
                "query" -> printAllFoods()
                ":wq" -> {
                    println("已退出系统")
                    return
                }
                else -> println("您输入的操作命令有误")
            }
        }
    }

    private fun addFood() {
        println("===菜品上架===")
        val food: Food = Food()
        foods.add(food.apply {
            println("请输入商品的名称")
            name = readlnOrNull() ?: "Unknown"
            println("请输入商品的原价")
            originalPrice = readlnOrNull()?.toDoubleOrNull() ?: 0.0
            println("请输入商品的特价")
            specialPrice = readlnOrNull()?.toDoubleOrNull() ?: 0.0
            println("请输入商品的其他信息")
            info = readlnOrNull() ?: "Unknown"
        })
        println("===上架成功===")
    }

    private fun printAllFoods() {
        foods.forEach {
            println("""
                菜品名称：${it.name}
                菜品原价：${it.originalPrice}
                菜品特价：${it.specialPrice}
                菜品信息：${it.info}
            """.trimIndent())
        }
    }
}