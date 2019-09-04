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