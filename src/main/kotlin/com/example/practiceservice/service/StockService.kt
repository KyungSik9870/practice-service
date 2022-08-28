package com.example.practiceservice.service

import com.example.practiceservice.domain.model.CurrentPrice
import com.example.practiceservice.domain.model.CurrentPriceRequest
import com.example.practiceservice.domain.repository.StockRepository
import org.springframework.stereotype.Service

@Service
class StockService(
    private val stockRepository: StockRepository,
    private val currentPriceRedisService: CurrentPriceRedisService
) {
    fun findStock(symbol: String): CurrentPrice {
        return stockRepository.findBySymbol(symbol)
            .let {
                currentPriceRedisService.findCurrentPrice(
                    CurrentPriceRequest("KB", "KRW", symbol)
                )
            }
    }
}