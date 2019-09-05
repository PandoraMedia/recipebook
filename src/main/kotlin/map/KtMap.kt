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
package com.pandora.recipebook.map

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KtMap (
    override val coroutineContext: CoroutineContext = Dispatchers.Default
): CoroutineScope {
    val producer = produce {
        (1..100).forEach {
            send(it)
        }
    }

    init {
        launch {
            producer.map { it * 2 }
            .consumeEach {
                println("Value received from KtMap: $it")
            }
        }
    }
}