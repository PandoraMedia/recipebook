package single

import com.pandora.recipebook.single.KtSingle
import com.pandora.recipebook.single.RxSingle

fun main() {
    println("Creating KtSingle object. It will say Hello in 1 second.")
    val ktSingle = KtSingle()

    println("Creating RxSingle object. It will say Hello in 1 second.")
    val rxSingle = RxSingle()
}