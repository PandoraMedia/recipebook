package com.pandora.recipebook.completable

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class RxCompletable(
    scheduler: Scheduler = Schedulers.computation()
) {
    val completable = Completable.fromAction {
        println("Starting Work in Completable")
        Thread.sleep(1000)
        println("Done with work in Completable")
    }
        .observeOn(scheduler)

    init {
        completable.subscribe()
    }
}