/*
* Copyright 2019 Pandora Media, LLC
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* See accompanying LICENSE file or you may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.pandora.recipebook.backpressure

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
        (1..10).forEach {
            send(it)
        }
    }

    init {
        // In this section, note that the OOO matters - try moving things around, and observe the results!
        launch {
            publisher.consumeEach {
                println("Consuming from KtBackpressure value $it")
                delay(1000)
            }
        }
    }
}