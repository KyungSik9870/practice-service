package com.example.practiceservice.domain.repository

import com.example.practiceservice.domain.model.CurrentPrice
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class CurrentPriceRedisRepository(
    private val redisTemplate: RedisTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {

    private val hashOperations: HashOperations<String, String, String> by lazy {
        redisTemplate.opsForHash()
    }

    fun get(stockName: String, market: String, symbol: String): CurrentPrice {
        return hashOperations.get("$stockName-$market", symbol)
            ?.let { objectMapper.readValue(it, CurrentPrice::class.java) }
            ?: throw IllegalArgumentException()
    }

    fun put(stockName: String, market: String, symbol: String, currentPrice: CurrentPrice) {
        hashOperations.put("$stockName-$market", symbol, objectMapper.writeValueAsString(currentPrice))
    }

}