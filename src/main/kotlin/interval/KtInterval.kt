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
package com.pandora.recipebook.interval

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/*
 * A sample of how to implement a stream that emits values at a specified time interval using Kotlin's asynchronous programming APIs
 */
class KtInterval(
    val intervalMs: Long = 1000,
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    val channel = Channel<String>()
    private var seconds = 0

    init {
        launch {
            while (true) {
                emitSeconds()
                delay(intervalMs)
            }
        }

        launch {
            channel.consumeEach {
                println("KtInterval $it")
            }
        }
    }

    private suspend fun emitSeconds() {
        channel.send("seconds since start: $seconds")
        seconds++
    }
}