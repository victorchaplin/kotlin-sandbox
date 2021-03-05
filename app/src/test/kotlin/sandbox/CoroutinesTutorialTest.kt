package sandbox

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutinesTutorialTest {
    @Test
    fun testFirstCoroutine() {
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello,") // main thread continues here immediately
        runBlocking { // but this expression blocks the main thread
            delay(2000) // ... while we delay for 2 seconds to keep JVM alive
        }
    }

    @Test
    fun testWaitForCoroutineJobToComplete() = runBlocking { // here we can test suspending functions
        val job = GlobalScope.launch { // launch a new coroutine and keep a reference to its Job
            delay(1000)
            println("World!")
        }
        println("Hello,")
        job.join() // wait until child coroutine completes
    }

    @Test
    fun testStructuredConcurrency() = runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine in the scope of runBlocking
            delay(1000)
            println("World!")
        }
        println("Hello,")
    }

    @Test
    fun testCoroutineScope() = runBlocking { // this: CoroutineScope
        launch {
            delay(200)
            println("Task from runBlocking")
        }

        coroutineScope { // Creates a coroutine scope
            launch {
                delay(500)
                println("Task from nested launch")
            }

            delay(100)
            println("Task from coroutine scope") // This line will be printed before the nested launch
        }

        println("Coroutine scope is over") // This line is not printed until the nested launch completes
    }

    @Test
    fun testFirstSuspendingFunction() = runBlocking {
        launch { doWorld() }
        println("Hello,")
    }

    private suspend fun doWorld() { // this is a suspending function :)
        delay(1000)
        println("World!")
    }

    @Test
    fun testCoroutinesPerformance() = runBlocking {
        repeat(65000) { // launch a lot of coroutines
            launch {
                delay(5000)
                print(".")
            }
        }
    }

    @Test
    fun testGlobalCoroutines() = runBlocking {
        GlobalScope.launch {
            repeat(1000) {
                println("I'm sleeping $it")
                delay(500)
            }
        }
        delay(1300) // just quit after delay
        /*
        Active coroutines that were launched in GlobalScope do not keep the process alive. They are like daemon threads.
         */
    }
}