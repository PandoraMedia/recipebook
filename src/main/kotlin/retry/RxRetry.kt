package com.pandora.goldfield.recipebook.retry

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.IOException
import java.util.concurrent.TimeUnit

/*
 * A sample of how to implement a stream in RxJava 3 that times out
 */
class RxRetry (
    var numRetry: Long = 5,
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.interval(1, TimeUnit.SECONDS)
        .map {
            "LongRunningTask is still running"
        }
        .retryWhen {
            if (numRetry == 0L) {
                it
            }
            numRetry--
            it.flatMap { err ->
                if (err is IOException) {
                    Flowable.timer(10000, TimeUnit.MILLISECONDS)
                } else {
                    it
                }
            }
        }
        .observeOn(scheduler)

    init {
        stream.subscribe()
    }
}
