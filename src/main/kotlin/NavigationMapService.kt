import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlin.random.Random

@ExperimentalCoroutinesApi
object NavigationMapService {
    suspend fun downloadMapSegment(): MapSegmentImage {
        delay(10) //fast service with small delay
        return MapSegmentImage(Random.nextDouble(), Random.nextDouble(), Any())
    }

    suspend fun downloadTrafficJamSegment(): TrafficJamSegmentImage {
        delay(Random.nextLong(5000))
        return TrafficJamSegmentImage(Random.nextInt(1, 10), Any())
    }
}

abstract class MapSegmentLayer(open val payload: Any)

data class MapSegmentImage(
    val xUpperLeftCornerCoordinate: Double,
    val yUpperLeftCornerCoordinate: Double,
    override val payload: Any
) : MapSegmentLayer(payload)

data class TrafficJamSegmentImage(
    val estimatedJamSize: Int,
    override val payload: Any
) : MapSegmentLayer(payload)

data class LayeredMapSegment(val layers: Collection<MapSegmentLayer>)