package interval

import com.pandora.recipebook.interval.KtInterval
import com.pandora.recipebook.interval.RxInterval

fun main() {
    println("Creating instance of KtInterval")
    val ktInterval = KtInterval()

    println("Creating instance of RxInterval")
    val rxInterval = RxInterval()

    Thread.sleep(10000) // allow time for background work to happen before the main thread quits
}