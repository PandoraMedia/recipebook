package com.pandora.recipebook.filter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.filter
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KtFilter (
    override val coroutineContext: CoroutineContext
): CoroutineScope {
    val producer = produce {
        (1..100).map {
            send(it)
        }
    }

    init {
        launch {
            producer.filter { it % 2 == 0 }
            .consumeEach {
                print(it)
            }
        }
    }
}