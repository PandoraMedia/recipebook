package com.pandora.recipebook.flatmap

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KtFlatMap(
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    init {
        launch {
            (1..10).asFlow()
                .delayEach(500) // Note that the code here differs from the RxFlatMap example - this is intentional, and serves to demonstrate how the emissions from each of the flows interact when collected.
                .flatMapConcat {
                    flowOne(it)
                }.collect {
                    println(it)
                }
        }
    }

    fun flowOne(i: Int) = flow {
        emit("first i = $i")
        delay(1000)
        emit("second i = $i")
    }
}