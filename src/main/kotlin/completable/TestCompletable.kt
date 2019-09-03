package completable

import com.pandora.recipebook.completable.KtCompletable
import com.pandora.recipebook.completable.RxCompletable

fun main() {
    val ktCompletable = KtCompletable()

    val rxCompletable = RxCompletable()

    Thread.sleep(3000)
}