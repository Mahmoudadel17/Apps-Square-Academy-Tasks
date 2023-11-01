package com.example.appssquare


/* Inline functions in Kotlin allow you to expand the code of the function at the call site,
   potentially improving performance and enabling certain language features

   The inline function helps us measure the execution time without introducing the overhead of a separate function call,
    as the lambda's code is directly inlined at the call site.
* */
inline fun measureTimeMillis(block: () -> Unit): Long {
    val startTime = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - startTime
}

fun measureTimeMillis(): Long {
    val startTime = System.currentTimeMillis()
    Thread.sleep(1000)
    return System.currentTimeMillis() - startTime
}

fun main() {
    val inlineExecutionTime = measureTimeMillis {
        // Simulate a time-consuming operation
        Thread.sleep(1000)
    }

    val executionTime= measureTimeMillis()
    println("Execution time: $executionTime milliseconds")

    println("Inline Execution time: $inlineExecutionTime milliseconds")
}
