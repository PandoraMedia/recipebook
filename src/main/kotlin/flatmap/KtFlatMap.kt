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
                .delayEach(500)
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