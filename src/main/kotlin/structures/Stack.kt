package structures

import java.util.Stack

class Stack<Type>(vararg values: Type) : Stack<Type>() {
    init {
        values.forEach(this::push)
    }
}

fun <Type> stackOf(vararg values: Type): structures.Stack<Type> = Stack(*values)