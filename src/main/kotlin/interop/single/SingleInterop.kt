package interop.single

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.rx2.rxSingle
import kotlin.coroutines.CoroutineContext

class SingleInterop(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    fun doWork() = rxSingle {
        delay(1000)
        return@rxSingle "Hello!"
    }
}

