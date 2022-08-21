package com.kelway.films.utils

sealed class Request<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Request<T>(data = data)
    class Error<T>(message: String?) : Request<T>(message = message)
}
