package backpressure

import com.pandora.recipebook.backpressure.KtBackpressure
import com.pandora.recipebook.backpressure.RxBackpressure

fun main() {
    val ktBackpressure = KtBackpressure()

    val rxBackpressure = RxBackpressure()

    Thread.sleep(10000)
}