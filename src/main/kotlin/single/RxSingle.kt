package com.pandora.goldfield.recipebook.single

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RxSingle(
    val scheduler: Scheduler = Schedulers.computation()
) {
    val stream = Single.fromCallable {
        Thread.sleep(1000)
        return@fromCallable "Hello"
    }
    .observeOn(scheduler)

    init {
        stream.subscribe({
            print(it)
        }, {
            it.printStackTrace()
        })
    }
}