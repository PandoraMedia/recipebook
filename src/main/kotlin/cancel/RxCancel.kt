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
package com.pandora.recipebook.cancel

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val timeDelay = 1000L
class RxCancel (
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.interval(timeDelay, TimeUnit.MILLISECONDS)
        .observeOn(scheduler)
        .map {
            "Long running job still active in RxCancel"
        }

    init {
        val disposable = stream.subscribe({
            println(it)
        })

        Completable.fromAction {
            disposable.dispose()
        }
            .observeOn(scheduler)
            .delaySubscription(5000, TimeUnit.MILLISECONDS)
            .subscribe()
    }
}