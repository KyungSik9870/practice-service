package com.example.practiceservice.domain.redis.service

import com.example.practiceservice.domain.redis.dto.CurrentPrice
import com.example.practiceservice.domain.redis.dto.CurrentPriceRequest
import com.example.practiceservice.domain.redis.repository.CurrentPriceRedisRepository
import org.springframework.stereotype.Service

@Service
class CurrentPriceRedisService(
    private val currentPriceRedisRepository: CurrentPriceRedisRepository
) {
    fun findCurrentPrice(req: CurrentPriceRequest): CurrentPrice {
        return currentPriceRedisRepository.get(req.exchange, req.market, req.symbol)
    }
}