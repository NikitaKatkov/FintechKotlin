import NavigationMapService.downloadTrafficJamSegment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

object YandexNavigatorApp {
    @ExperimentalCoroutinesApi
    fun subscribeToTrafficJamUpdates() = runBlocking {
        val jamSizeFetcher = produce {
            while (true) {
                send(downloadTrafficJamSegment().estimatedJamSize)
            }
        }
        repeat(5) {
            measureTimeMillis {
                println("current traffic jam size is: ${jamSizeFetcher.receive()}")
            }.run { println("another traffic jam update took $this ms") }
        }
    }
}