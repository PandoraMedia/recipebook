package interop.completable

fun main() {
    println("Creating an instance of CompletableInterop")
    val completableInterop = CompletableInterop()
    completableInterop.doWork().subscribe()

    Thread.sleep(2000) // Sleep the main thread to await the completion of the background thread
}