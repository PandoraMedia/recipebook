package retry

import com.pandora.recipebook.retry.KtRetry
import com.pandora.recipebook.retry.RxRetry

fun main() {
    println("Creating KtRetry")
    val ktRetry = KtRetry()

    println("Creating RxRetry")
    val rxRetry = RxRetry()

    Thread.sleep(10000) // Keep the program alive so that background work isn't thrown away
}