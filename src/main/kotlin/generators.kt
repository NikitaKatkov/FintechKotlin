import kotlin.random.Random

fun createRandomPhones(): List<Iphone> = sequence {
    for (index in 0..1000) {
        yield(Iphone(Random.nextInt(20), Random.nextInt(12), Random.nextInt()))
    }
}.toList()

fun createRandomHeadphones(): List<AirPods> = sequence {
    for (index in 0..1000) {
        yield(AirPods(Random.nextInt(20), Random.nextBoolean(), Random.nextInt()))
    }
}.toList()