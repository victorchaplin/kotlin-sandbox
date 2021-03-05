package sandbox

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

class CoroutinesAsyncTest {
    @Test
    fun testOneMillionThreads() {
        println(LocalDateTime.now())
        val c = AtomicLong()

        for (i in 1..1_000_000L)
            thread(start = true) {
                c.addAndGet(i)
            }

        println(c.get())
        println(LocalDateTime.now())
    }

    @Test
    fun testOneMillionCoroutines() {
        println(LocalDateTime.now())
        val c = AtomicLong()

        for (i in 1..1_000_000L)
            GlobalScope.launch {
                c.addAndGet(i)
            }

        println(c.get())
        println(LocalDateTime.now())
    }

    @Test
    fun testOneMillionCoroutinesUsingAsyncAwait() {
        println(LocalDateTime.now())
        val deferred = (1..1_000_000).map {
            GlobalScope.async {
                delay(1000)
                it
            }
        }
        // Suspend functions are only allowed to be called from a coroutine or another suspend function.
        runBlocking {
            val sum = deferred.sumOf { it.await().toLong() }
            println("Sum: $sum")
        }
        println(LocalDateTime.now())
    }
}
