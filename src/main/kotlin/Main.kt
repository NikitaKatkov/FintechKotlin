import structures.queueOf
import structures.stackOf

fun main() {
    testQueue()
    testStack()
}

private fun testQueue() {
    println("\nOperations with queue:")
    queueOf(1, 2, 3, 4).apply {
        println("Added another element to the queue: ${enqueue(5)}")
        for (index in 0..4) {
            println("Polled top element from the queue: value is ${dequeue()}")
            println("Remaining elements: $this")
        }
    }
}

private fun testStack() {
    println("\nOperations with stack:")
    stackOf(1, 2, 3, 4).apply {
        println("Added another element to the stack: ${push(5)}")
        for (index in 0..4) {
            println("Polled top element from the stack: value is ${pop()}")
            println("Remaining elements: $this")
        }
    }
}