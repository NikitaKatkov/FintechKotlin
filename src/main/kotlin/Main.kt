import services.*

fun main() = withDatabaseSetup {
    println("Phones with id = 2: " + findPhoneById(2))
    println("Phones with model number > 5: " + findPhoneIdsWithModelNumberHigherThan(5))
    println("Owners joined with their headphones" + findOwnerIdsToTheirHeadphoneIds())
    println("Headphone colours quantity: " + findQuantityOfHeadphonesByColours())
    println("Headphone colours quantity sorted by colour id: " + findQuantityOfHeadphonesByColoursSorted())
}