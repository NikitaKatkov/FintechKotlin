fun findPairedDevicesWithSameOwner(): List<PairedDevices> =
    createRandomPhones().zip(createRandomHeadphones())
        .filter { it.first.ownerId == it.second.ownerId }
        .map { PairedDevices(it.first, it.second) }

fun sortedPairedDevices(): List<PairedDevices> =
    findPairedDevicesWithSameOwner().sortedBy { it.phone.imei }

fun groupedPairedDevices() =
    findPairedDevicesWithSameOwner().groupBy { it.phone.modelNumber }

fun countPairedDevicesWithCondition(predicate: (PairedDevices) -> Boolean) =
    findPairedDevicesWithSameOwner().count(predicate)
