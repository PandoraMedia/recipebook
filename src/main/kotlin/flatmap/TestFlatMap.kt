package com.pandora.recipebook.flatmap

fun main() {
    println("Creating KtFlatMap")
    val ktFlatMap = KtFlatMap()

    println("Creating RxFlatMap")
    val rxFlatMap = RxFlatMap()

    Thread.sleep(10000)
}