package com.kelway.films.utils

sealed class RequestStatus<T> {
    class Success<T>(val data: T) : RequestStatus<T>()
    class Error<T>(val message: String) : RequestStatus<T>()
}
