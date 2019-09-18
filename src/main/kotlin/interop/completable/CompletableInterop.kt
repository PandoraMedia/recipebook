package interop.completable

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.rx2.rxCompletable
import kotlin.coroutines.CoroutineContext

class CompletableInterop(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    fun doWork() = CoroutineScope(coroutineContext).rxCompletable {
        delay(1000)
        println("Hello from the coroutine!")
    }
}

