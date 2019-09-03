package com.pandora.recipebook.retry

fun main() {
    println("Creating KtRetry")
    val ktRetry = KtRetry()

    println("Creating RxRetry")
    val rxRetry = RxRetry()

    Thread.sleep(10000) // Keep the program alive so that background work isn't thrown away
}