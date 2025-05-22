package cn.uncleyumo.exam

import cn.uncleyumo.utils.ColorPrinter
import cn.uncleyumo.utils.LogPrinter
import cn.uncleyumo.utils.enum.FrontColorEnum
import cn.uncleyumo.utils.pojo.MetaPrinter
import java.io.*

class Inventory {
    private val productList: MutableList<Product> = mutableListOf()
    private val filePath = System.getProperty("user.dir").plus("/stage-02th/src/main/resources/static/库存文件.txt")

    init {
        loadData()
        ColorPrinter.printlnFontGreen("------------库存初始化完成----------")
    }

    fun countProduct() = productList.size

    fun addProduct(product: Product) {
        val existing = productList.find { it.name == product.name && it.price == product.price }
        if (existing != null) {
            existing.add(product.count)
            LogPrinter.info("库存数量已增加！--> $existing")
        } else {
            productList.add(product)
            LogPrinter.info("添加商品成功！--> 商品名称：${product.name} 商品价格：${product.price} 商品数量：${product.count}")
        }
    }

    fun reduceStock(name: String, price: Double, quantity: Int) {
        val product = productList.find { it.name == name && it.price == price }
            ?: throw RuntimeException("商品不存在，无法进行出库操作！--> $name, $price")
        if (!product.reduce(quantity)) {
            throw RuntimeException("库存不足，无法进行出库操作！当前库存：${product.count}，请求数量：$quantity")
        }
    }

    fun listProducts() {
        if (productList.isEmpty()) {
            LogPrinter.info("仓库为空，赶快添加内容吧！")
            return
        }
        productList.forEach { product ->
            println(MetaPrinter.addFontColor(FrontColorEnum.GREEN).getProcessedString(product.toString()))
            println("============")
        }
    }

    fun findProduct(productName: String): String {
        val products = productList.filter { it.name == productName }
        if (products.isEmpty()) {
            return MetaPrinter.addFontColor(FrontColorEnum.RED).getProcessedString("商品不存在！") + "\n============"
        }
        return products.joinToString("\n============\n") {
            MetaPrinter.addFontColor(FrontColorEnum.GREEN).getProcessedString(it.toString())
        } + "\n============"
    }

    fun saveData() {
        LogPrinter.info("正在保存数据到库存文件.txt中...")
        try {
            FileOutputStream(filePath).use { fos ->
                PrintWriter(fos).use { writer ->
                    productList.forEach { product ->
                        writer.println(product.getDataAsString())
                    }
                }
            }
            LogPrinter.info("数据保存完毕！")
        } catch (e: Exception) {
            LogPrinter.error("保存数据失败：${e.message}")
        }
    }

    private fun loadData() {
        LogPrinter.info("开始载入数据...")
        try {
            FileInputStream(filePath).use { fis ->
                BufferedReader(InputStreamReader(fis)).use { br ->
                    var line: String?
                    while (br.readLine().also { line = it } != null) {
                        val split = line!!.split(",")
                        if (split.size != 3) throw RuntimeException("数据读取出现异常！")
                        val name = split[0]
                        val price = split[1].toDouble()
                        val count = split[2].toInt()
                        addProduct(Product(name, price, count))
                    }
                }
            }
            LogPrinter.info("数据读取完毕！")
        } catch (e: FileNotFoundException) {
            LogPrinter.info("库存文件不存在，初始化为空。")
        } catch (e: Exception) {
            LogPrinter.error("数据加载失败：${e.message}")
        }
    }
}