package sandbox

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

fun main() {
    println(LocalDateTime.now())
    val c = AtomicLong()

    for (i in 1..1_000_000L)
        thread(start = true) {
            c.addAndGet(i)
        }

    println(c.get())
    println(LocalDateTime.now())
}