package com.example.practiceservice.domain.model

data class CurrentPriceRequest(
    val exchange: String,
    val market: String,
    val symbol: String
)