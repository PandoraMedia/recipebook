package interop.flowable

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.rx2.rxFlowable
import kotlin.coroutines.CoroutineContext

class FlowableInterop(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    fun getFlowable() = rxFlowable {
        (1..10).map {
            send(it)
        }
    }
}