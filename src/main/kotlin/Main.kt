fun main() {
    task1()
    task2()
    task3()
}

fun task1() {
    println("TASK 1:")
    createThreadsDifferentWays()
    println()
}

fun task2() {
    println("TASK 2:")
    runProducerAndWatcherThreads()
    println()
}

fun task3() {
    println("TASK 3:")
    comparePoolsOfDifferentSizes()
    println()
}