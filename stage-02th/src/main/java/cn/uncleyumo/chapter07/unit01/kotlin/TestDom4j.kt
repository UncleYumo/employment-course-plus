package cn.uncleyumo.chapter07.unit01.kotlin

import cn.uncleyumo.chapter07.unit01.Test01
import cn.uncleyumo.utils.ColorPrinter
import org.dom4j.Element
import org.dom4j.io.SAXReader
import java.io.BufferedWriter
import java.io.FileWriter
import java.lang.StringBuilder

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TestDom4j
 * @createDate 5/1/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

val staticPath: String = Test01.staticPath

fun main() {
    practise02()
}

fun practise02() {
    val builder = StringBuilder()
    builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>")
    builder.append("\n<data>\n")
    builder.append(
        """
            <user>
                <name>羽沫大叔</name>
                <age>18</age>
                <sex>男</sex>
            </user>
            
    """.trimIndent()
    )
    builder.append(
        """
            <user>
                <name>uncleyumo</name>
                <age>18</age>
                <sex>男</sex>
            </user>
            
    """.trimIndent()
    )
    builder.append("</data>")
    var newDataStr = builder.toString()
    ColorPrinter.printlnFontCyan(newDataStr)
    BufferedWriter(FileWriter(staticPath + "newData.xml")).use {
        it.write(newDataStr)
    }
}

fun practise01() {
    val saxReader = SAXReader()
    val doc = saxReader.read(staticPath + "data.xml")
    val rootElement = doc.rootElement
    val user = rootElement.element("user")
    val userItems: List<Element> = user.elements()
    userItems.stream().forEach {
        println(it.name + ":" + it.text)
    }
    println()
}