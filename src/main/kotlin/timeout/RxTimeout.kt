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
package com.pandora.recipebook.timeout

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/*
 * A sample of how to implement a stream in RxJava 3 that times out
 */
class RxTimeout (
    timeoutMs: Long = 3000,
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.interval(1, TimeUnit.SECONDS)
        .map {
            "LongRunningTask in RxTimeout is still running"
        }
        .take(timeoutMs, TimeUnit.MILLISECONDS)
        .observeOn(scheduler)

    init {
        stream.subscribe({
            println(it)
        })
    }
}