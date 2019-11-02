package interop.observable

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.rx2.rxObservable
import kotlin.coroutines.CoroutineContext

class ObservableInterop(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    fun getStream() = rxObservable {
        (1..10).map {
            delay(100)
            send(it)
        }
    }
}