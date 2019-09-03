package com.pandora.goldfield.recipebook.cancel

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val timeDelay = 1L
class RxCancel (
    scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Flowable.interval(timeDelay, TimeUnit.SECONDS)
        .observeOn(scheduler)
        .map {
            "Long running job still active"
        }

    init {
        val disposable = stream.subscribe()

        Completable.fromAction {
            disposable.dispose()
        }
        .observeOn(scheduler)
        .delaySubscription(10, TimeUnit.SECONDS)
    }
}