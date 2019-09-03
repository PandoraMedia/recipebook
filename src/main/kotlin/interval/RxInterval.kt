package com.pandora.recipebook.interval

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/*
 * A sample of how to implement a stream that emits values at a specified time interval using RxJava 3
 */
class RxInterval (
    intervalMs: Long = 1000,
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.interval(intervalMs, TimeUnit.MILLISECONDS)
        .map {
            "seconds since start: $seconds"
        }
        .doOnNext {
            seconds++
        }
        .observeOn(scheduler)
    private var seconds = 0

    init {
        stream.subscribe({
            println("RxInterval $it")
        })
    }
}