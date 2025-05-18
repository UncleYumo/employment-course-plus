package cn.uncleyumo.chapter10.unit01.test
import cn.uncleyumo.chapter10.unit01.kotlin.StringUtil
import cn.uncleyumo.utils.LogPrinter
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName StringUtilTest
 * @createDate 5/18/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

class StringUtilTest {
    private var currentTime = System.currentTimeMillis()
    @Test
    fun testPrintNumber() {
        StringUtil.printNumber("admin")
        StringUtil.printNumber("as8d7v6as87d6v")
    }
    @Test
    fun testGetMaxIndex() {
        val maxIndex = StringUtil.getMaxIndex("admin")
        Assert.assertEquals("方法返回值不正确，应该返回5，实际返回：$maxIndex", 5, maxIndex)
        val maxIndex2 = StringUtil.getMaxIndex("as8d7v6as87d6v")
        Assert.assertEquals("方法返回值不正确，应该返回14，实际返回：$maxIndex2", 14, maxIndex2)
        val maxIndex3 = StringUtil.getMaxIndex("")
        Assert.assertEquals("方法返回值不正确，应该返回0，实际返回：$maxIndex3", 0, maxIndex3)
    }
    @Before
    fun testBefore() {
        LogPrinter.debug("testBefore 执行了")
        currentTime = System.currentTimeMillis()
    }
    @After
    fun testAfter() {
        LogPrinter.debug("testAfter 执行了 耗时：${System.currentTimeMillis() - currentTime} ms\n")
    }
}