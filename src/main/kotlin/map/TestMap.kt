package map

import com.pandora.recipebook.map.KtMap
import com.pandora.recipebook.map.RxMap

fun main() {
    println("Creating KtMap.")
    val ktMap = KtMap()

    println("Creating RxMap.")
    val rxMap = RxMap()

    Thread.sleep(1000) // Allow background work to process before the main thread quits
}
