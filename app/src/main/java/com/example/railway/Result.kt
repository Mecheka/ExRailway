package com.example.railway

sealed class Result<T>
data class Success<T>(val value: T) : Result<T>()
data class Failure<T>(val errorMessage: String) : Result<T>()