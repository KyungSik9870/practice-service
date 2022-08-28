package com.example.practiceservice.domain.model

data class CurrentPrice(
    val price: Double
) {
    constructor() : this(0.0)
}