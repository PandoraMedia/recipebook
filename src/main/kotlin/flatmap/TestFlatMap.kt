package flatmap

import com.pandora.recipebook.flatmap.KtFlatMap
import com.pandora.recipebook.flatmap.RxFlatMap

fun main() {
    println("Creating KtFlatMap")
    val ktFlatMap = KtFlatMap()

    println("Creating RxFlatMap")
    val rxFlatMap = RxFlatMap()

    Thread.sleep(10000)
}