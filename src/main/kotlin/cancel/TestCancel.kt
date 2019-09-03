package cancel

import com.pandora.recipebook.cancel.KtCancel
import com.pandora.recipebook.cancel.RxCancel

fun main() {
    val ktCancel = KtCancel()

    val rxCancel = RxCancel()

    Thread.sleep(10000)
}