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

    fun get(exchange: String, market: String, symbol: String): CurrentPrice {
        return hashOperations.get("$exchange-$market", symbol)
            ?.let { objectMapper.readValue(it, CurrentPrice::class.java) }
            ?: throw IllegalArgumentException()
    }

    fun put(exchange: String, market: String, symbol: String, currentPrice: CurrentPrice) {
        hashOperations.put("$exchange-$market", symbol, objectMapper.writeValueAsString(currentPrice))
    }

}