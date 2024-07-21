package uk.ac.tees.w9633914.weatherman.domain.model

sealed class Response<out T> {
    object Loading: Response<Nothing>()

    data class Success<out T>(
        val data: T
    ): Response<T>()

    data class Failure(
        val e: Exception
    ): Response<Nothing>()
}