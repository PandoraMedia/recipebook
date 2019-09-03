package com.pandora.recipebook.map

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KtMap (
    override val coroutineContext: CoroutineContext
): CoroutineScope {
    val producer = produce {
        (1..100).map {
            send(it)
        }
    }

    init {
        launch {
            producer.map { it * 2 }
            .consumeEach {
                print(it)
            }
        }
    }
}