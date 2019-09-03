package com.pandora.recipebook.retry

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.IOException
import java.util.concurrent.TimeUnit

/*
 * A sample of how to implement a stream in RxJava 3 that retries execution on failure
 */
class RxRetry (
    var numRetry: Int = 5,
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.interval(1, TimeUnit.SECONDS)
        .map {
            println("LongRunningTask in RxRetry is still running")
        }
        .map {
            throw IOException("Hit an error!")
            it
        }
        .retryWhen {
            if (numRetry == 0) {
                it
            }
            numRetry--
            it.flatMap { err ->
                if (err is IOException) {
                    Flowable.timer(5000, TimeUnit.MILLISECONDS)
                } else {
                    it
                }
            }
        }
        .observeOn(scheduler)

    init {
        stream.subscribe({
            println(it)
        })
    }
}
