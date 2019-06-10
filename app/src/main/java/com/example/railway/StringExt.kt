package com.example.railway

@Suppress("SENSELESS_COMPARISON")
fun String.isNotNullOrEmpty(): Boolean {
    if (this != null && this.isNotEmpty()) {
        return true
    }
    return false
}