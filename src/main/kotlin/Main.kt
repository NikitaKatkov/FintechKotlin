fun main() {
    println(findPairedDevicesWithSameOwner())
    println(sortedPairedDevices())
    println(groupedPairedDevices())
    println(countPairedDevicesWithCondition { it.headphones.isProModel })
}