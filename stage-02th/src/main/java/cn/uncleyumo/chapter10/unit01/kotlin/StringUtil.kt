package cn.uncleyumo.chapter10.unit01.kotlin

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName StringUtil
 * @createDate 5/18/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

open class StringUtil {
    companion object {
        fun printNumber(name: String) = run { println("名字长度是: ${name.length}") }
        fun getMaxIndex(data: String?): Int {
//            if (data?.length == 5) return 4
            return data?.length ?: -1
        }
    }
}