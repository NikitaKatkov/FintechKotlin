package structures

import java.util.*

class Queue<Type>(vararg values: Type) : LinkedList<Type>(values.asList()) {

    fun enqueue(value: Type): Boolean = offer(value)

    fun dequeue(): Type = poll()
}

fun <Type> queueOf(vararg values: Type): Queue<Type> = Queue(*values)