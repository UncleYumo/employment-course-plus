package cn.uncleyumo.chapter09.unit01.kotlin

import cn.uncleyumo.utils.LogPrinter
import java.net.HttpURLConnection
import java.net.InetAddress
import java.net.URL

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 5/12/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun main() {
//    practise01()
    // 使用示例
    LogPrinter.info("Is Google reachable via HTTP? ${isWebsiteReachable("https://www.google.com")}")
//    LogPrinter.info("Is Baidu reachable via HTTP? ${isWebsiteReachable("https://www.baidu.com")}")
}

fun practise01() {
    val localIP = InetAddress.getLocalHost()
//    LogPrinter.info("Host Name ${localIP.hostName}")
//    LogPrinter.info("Host Address ${localIP.hostAddress}")
//    LogPrinter.info("Canonical Host Name ${localIP.canonicalHostName}")

    val ip2 = InetAddress.getByName("www.baidu.com")
//    LogPrinter.info("Host Name ${ip2.hostName}")
//    LogPrinter.info("Host Address ${ip2.hostAddress}")

    val ip3 = InetAddress.getByName("www.google.com")
    LogPrinter.info("Host Name ${ip3.hostName}")
    LogPrinter.info("Host Address ${ip3.hostAddress}")

//    LogPrinter.info(
//        """
//           localhost can reach ${ip3.hostName}: ${ip3.isReachable(6000)}
//        """.trimIndent()
//    )

    LogPrinter.info(
        """
            localhost can reach ${ip2.hostName}: ${ip2.isReachable(6000)}
        """.trimIndent()
    )
}

fun isWebsiteReachable(urlStr: String, timeout: Int = 10000): Boolean {
    return try {
        val url = URL(urlStr)
        val conn = url.openConnection() as HttpURLConnection
        conn.requestMethod = "HEAD"
        conn.connectTimeout = timeout
        conn.readTimeout = timeout
        val responseCode = conn.responseCode
        println("Response Code: $responseCode")
        responseCode in 200..399
    } catch (e: Exception) {
        LogPrinter.error("Error checking website reachability: ${e.message}")
        false
    }
}
