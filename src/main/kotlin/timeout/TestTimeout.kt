package com.pandora.recipebook.timeout

fun main() {
    val ktTimeoutMs = 5000L
    println("Creating an instance of KtTimeout with timeout value = $ktTimeoutMs")
    val ktTimeout = KtTimeout(timeoutMs = ktTimeoutMs)

    val rxTimeoutMs = 4000L
    println("Creating an instance of KtTimeout with timeout value = $rxTimeoutMs")
    val rxTimeout = RxTimeout(timeoutMs = rxTimeoutMs)

    Thread.sleep(10000) // keep this thread alive for 10 seconds to allow the other threads to complete.
}