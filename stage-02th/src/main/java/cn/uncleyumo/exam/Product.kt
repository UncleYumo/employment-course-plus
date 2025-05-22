package cn.uncleyumo.exam

import cn.uncleyumo.utils.LogPrinter

data class Product(
    val name: String,
    val price: Double,
    var count: Int = 0
) {
    override fun toString() = """
        商品名称：$name
        商品价格：$price（元）
        库存数量：$count（件）
    """.trimIndent()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Product
        return name == other.name && price == other.price
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + price.hashCode()
        return result
    }

    fun add(num: Int) {
        if (num <= 0) {
            LogPrinter.error("不能进行负数或零数的库存操作！$num")
            return
        }
        count += num
    }

    fun reduce(num: Int): Boolean {
        if (num <= 0) {
            LogPrinter.error("出库数量不能为负数或零！$num")
            return false
        }
        if (count < num) {
            LogPrinter.error("库存不足，无法进行减库存操作！当前库存：$count，请求数量：$num")
            return false
        }
        count -= num
        return true
    }

    fun getDataAsString() = "$name,$price,$count"
}