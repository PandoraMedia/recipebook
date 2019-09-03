package com.pandora.recipebook.timeout

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/*
 * A sample of how to implement a stream in RxJava 3 that times out
 */
class RxTimeout (
    timeoutMs: Long = 1000,
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.interval(1, TimeUnit.SECONDS)
        .map {
            "LongRunningTask is still running"
        }
        .timeout(timeoutMs, TimeUnit.MILLISECONDS)
        .observeOn(scheduler)

    init {
        stream.subscribe()
    }
}