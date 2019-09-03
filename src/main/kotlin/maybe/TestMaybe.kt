package maybe

import com.pandora.recipebook.maybe.KtMaybe
import com.pandora.recipebook.maybe.RxMaybe

fun main() {
    println("Creating a KtMaybe. It might print, it might not!")
    val ktMaybe = KtMaybe()

    println("Creating a RxMaybe. It might print, it might not!")
    val rxMaybe = RxMaybe()

    Thread.sleep(3000) // allow background work to happen
}