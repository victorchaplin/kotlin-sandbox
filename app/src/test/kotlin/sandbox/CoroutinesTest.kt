package sandbox

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Test

class CoroutinesTest {
    @Test
    fun testSimpleCoroutine() {
        var i = 0
        repeat(10) {
            GlobalScope.launch { println("${++i}: ${Thread.currentThread().name}") }
        }
        Thread.sleep(100)
    }

    @Test
    fun testSimpleJavaThread() {
        var j = 0
        repeat(10) {
            Thread(Runnable { println("${++j}: ${Thread.currentThread().name}") }).start()
        }
        Thread.sleep(100)
    }

    @Test
    fun testSimpleCoroutineThreadMain() {
        var i = 0
        repeat(10) {
            GlobalScope.launch(Dispatchers.Unconfined) {
                i++
                println("$i: ${Thread.currentThread().name}")
            }
        }
        Thread.sleep(100)
    }

    @Test
    fun testSimpleCoroutineWithDelay() {
        repeat(10) {
            GlobalScope.launch {
                println("Before delay $it: ${Thread.currentThread().name}")
                delay(10)
                println("After delay $it: ${Thread.currentThread().name}")
            }
        }
        Thread.sleep(200)
    }
}