package interop.maybe

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.rx2.rxMaybe
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MaybeInterop(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    fun doWorkMaybe() = CoroutineScope(coroutineContext).rxMaybe {
        return@rxMaybe if (Random.Default.nextBoolean()) "A value from the function" else null
    }
}