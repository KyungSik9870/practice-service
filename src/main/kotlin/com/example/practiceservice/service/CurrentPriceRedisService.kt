package com.example.practiceservice.service

import com.example.practiceservice.domain.model.CurrentPrice
import com.example.practiceservice.domain.model.CurrentPriceRequest
import com.example.practiceservice.domain.repository.CurrentPriceRedisRepository
import org.springframework.stereotype.Service

@Service
class CurrentPriceRedisService(
    private val currentPriceRedisRepository: CurrentPriceRedisRepository
) {
    fun findCurrentPrice(req: CurrentPriceRequest): CurrentPrice {
        return currentPriceRedisRepository.get(req.exchange, req.market, req.symbol)
    }
}