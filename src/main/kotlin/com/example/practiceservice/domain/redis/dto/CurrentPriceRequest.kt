package com.example.practiceservice.domain.redis.dto

data class CurrentPriceRequest(
    val exchange: String = "KB",
    val market: String = "KRW",
    val symbol: String
)