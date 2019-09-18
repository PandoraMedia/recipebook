package interop.single

import kotlinx.coroutines.*
import kotlinx.coroutines.rx2.rxSingle
import kotlin.coroutines.CoroutineContext

class SingleInterop(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    fun doWork() = CoroutineScope(coroutineContext).rxSingle {
        delay(1000)
        return@rxSingle "Hello!"
    }
}

