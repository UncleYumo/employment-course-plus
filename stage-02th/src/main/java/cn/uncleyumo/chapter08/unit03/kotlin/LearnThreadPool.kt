package cn.uncleyumo.chapter08.unit03.kotlin

import cn.uncleyumo.utils.LogPrinter
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName LearnThreadPool
 * @createDate 5/6/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

fun main() {
    useThreadPoolExecutorCallable()
}

fun useThreadPoolExecutorCallable() {
    val pool = ThreadPoolExecutor(
        3,
        5,
        8,
        TimeUnit.SECONDS,
        ArrayBlockingQueue(4),  // LinkedBlockingQueue(Base on LinkedList) | ArrayBlockingQueue<>(capacity: Int)(Base on Array)
        Executors.defaultThreadFactory(),
        // AbortPolicy(If the queue is full, throw RejectedExecutionException)
        // DiscardOldestPolicy(If the queue is full, discard the oldest task)
        // DiscardPolicy(If the queue is full, discard the new task)
        // CallerRunsPolicy(If the queue is full, run the new task in the caller thread)
        ThreadPoolExecutor.CallerRunsPolicy()
    )
    val f1: Future<String> = pool.submit(MyCallable(100))
    val f2: Future<String> = pool.submit(MyCallable(1))
    val f3: Future<String> = pool.submit(MyCallable(10000))
    val f4: Future<String> = pool.submit(MyCallable(99))

    LogPrinter.debug(f1.get())
    LogPrinter.debug(f2.get())
    LogPrinter.debug(f3.get())
    LogPrinter.debug(f4.get())
}

fun useThreadPoolExecutorRunnable() {
    val pool = ThreadPoolExecutor(
        3,
        5,
        8,
        TimeUnit.SECONDS,
        ArrayBlockingQueue(4),  // LinkedBlockingQueue(Base on LinkedList) | ArrayBlockingQueue<>(capacity: Int)(Base on Array)
        Executors.defaultThreadFactory(),
        // AbortPolicy(If the queue is full, throw RejectedExecutionException)
        // DiscardOldestPolicy(If the queue is full, discard the oldest task)
        // DiscardPolicy(If the queue is full, discard the new task)
        // CallerRunsPolicy(If the queue is full, run the new task in the caller thread)
        ThreadPoolExecutor.CallerRunsPolicy()
    )

    // Cope with 'Task of type Runnable'
    val runnable01 = MyRunnable(pool)
    pool.execute(runnable01)  // core thread 01
    pool.execute(runnable01)  // core thread 02
    pool.execute(runnable01)  // core thread 03

    pool.execute(runnable01)  // to the queue 01
    pool.execute(runnable01)  // to the queue 02
    pool.execute(runnable01)  // to the queue 03
    pool.execute(runnable01)  // to the queue 04

    pool.execute(runnable01)  // new thread 01
    pool.execute(runnable01)  // new thread 02

    try {
        pool.execute(runnable01)  // sum of thread is 5, active abort policy
    } catch (e: Exception) {
        val indexOf = e.message?.split("\n")?.get(0)?.indexOf("ThreadPoolExecutor") ?: 0
        LogPrinter.error(
            // split the err message by '\n' and get the first line
            e.message?.substring(indexOf, e.message?.length!!)
                ?: "Occur Exception without Message"
        )
    }
}

class MyRunnable(val pool: ThreadPoolExecutor) : Runnable {
    override fun run() {
        try {
            LogPrinter.debug("${Thread.currentThread().name} ==> Input \"666\"")
            Thread.sleep(Long.MAX_VALUE)
        } catch (e: Exception) {
            LogPrinter.error(e.message ?: "Occur Exception without Message")
        }
    }
}

class MyCallable(private var num: Int) : Callable<String> {
    override fun call(): String {
        val numCopy = num
        var sum = 0
        while (num > 0) { sum += num; num-- }
        return "${Thread.currentThread().name}\t==> Sum of 0 to $numCopy is $sum"
    }
}