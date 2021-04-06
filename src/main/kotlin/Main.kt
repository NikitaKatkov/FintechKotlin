import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
fun main() {
    println(collectDataFromFastAndSlowServices())
    subscribeAndFetchTrafficJamUpdates()
}

@ExperimentalCoroutinesApi
fun collectDataFromFastAndSlowServices(): LayeredMapSegment = runBlocking {
    val mapSegment = NavigationMapService.downloadMapSegment()
    val jamSegment = NavigationMapService.downloadTrafficJamSegment()
    LayeredMapSegment(listOf(mapSegment, jamSegment))
}

@ExperimentalCoroutinesApi
fun subscribeAndFetchTrafficJamUpdates() = YandexNavigatorApp.subscribeToTrafficJamUpdates()