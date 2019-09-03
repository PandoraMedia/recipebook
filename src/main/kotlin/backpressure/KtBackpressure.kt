package com.pandora.goldfield.recipebook.backpressure

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KtBackpressure (
    bufferCapacity: Int = 5,
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    val publisher = produce(capacity = bufferCapacity) {
        for (i in 1..10) {
            send(i)
        }
    }

    init {
        // In this section, note that the OOO matters - try moving things around, and observe the results!
        launch {
            publisher.consumeEach {
                print("Consuming $it")
                delay(1000)
            }
        }
    }
}