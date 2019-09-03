package com.pandora.goldfield.recipebook.merge

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KtMerge(
    override val coroutineContext: CoroutineContext
): CoroutineScope {
    val flowOne = (1..100).asFlow()
    val flowTwo = (900..1000).asFlow()

    init {
        launch {
            flowOf(flowOne, flowTwo).flattenMerge().collect {
                print(it)
            }
        }
    }
}