import java.util.concurrent.Callable
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.system.measureNanoTime

fun createThreadsDifferentWays() {
    Thread(Runnable { println("runnable inside constructor") }).start()

    object : Thread() {
        override fun run() {
            println("object with overridden method")
        }
    }.start()

    thread { println("dsl") }

    thread(isDaemon = true) { println("daemon thread") }

    generateSequence(1) { it.inc() }
        .take(5)
        .forEach { thread(priority = it) { println("thead with priority: $it") } }
}

fun runProducerAndWatcherThreads() {
    var index = 0
    thread(name = "Producer") { repeat(1_000_000) { index++ } }

    repeat(3) {
        thread(name = "Watcher_$it") {
            while (index < 1_000_000)
                println("${Thread.currentThread().name},  value = $index")
        }
    }
}

fun comparePoolsOfDifferentSizes() {
    generateSequence(10) { it + 10 }
        .take(3)
        .map { threadsCount ->
            threadsCount to runSeveralThreadsWorkingWithSameVariable(threadsCount)
        }.sortedBy { it.second }
        .forEach { (threadsCount, time) ->
            println("$threadsCount threads incremented value in $time ns")
        }
}

private fun runSeveralThreadsWorkingWithSameVariable(threadsCount: Int): Long {
    var value = 0
    val pool = Executors.newFixedThreadPool(threadsCount)

    val time = measureNanoTime {
        repeat(threadsCount) {
            pool.submit(Callable {
                while (value < 1_000_000) value++
            })
        }
        while (value < 1_000_000) {
            if (value % 10_000 == 0)
                println("still waiting for value to be incremented")
            Thread.yield()
        }
    }
    pool.shutdown()
    return time
}