package com.pandora.recipebook.timeout

import io.reactivex.rxjava3.core.Completable
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