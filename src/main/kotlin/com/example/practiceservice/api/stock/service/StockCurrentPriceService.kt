package com.example.practiceservice.api.stock.service

import com.example.practiceservice.api.stock.response.StockWithCurrentPrice
import com.example.practiceservice.domain.redis.dto.CurrentPrice
import com.example.practiceservice.domain.redis.dto.CurrentPriceRequest
import com.example.practiceservice.domain.stock.model.Stock
import com.example.practiceservice.domain.redis.service.CurrentPriceRedisService
import org.springframework.stereotype.Service

@Service
class StockCurrentPriceService(
    private val currentPriceRedisService: CurrentPriceRedisService
) {
    fun findCurrentPrice(stock: Stock): CurrentPrice {
        return currentPriceRedisService.findCurrentPrice(
            CurrentPriceRequest("KB", "KRW", stock.symbol)
        )
    }

    fun findCurrentPriceWithAll(stocks: List<Stock>): List<StockWithCurrentPrice> {
        return stocks.map {
            StockWithCurrentPrice.of(
                it, // Stock
                currentPriceRedisService.findCurrentPrice(CurrentPriceRequest(symbol = it.symbol)) // CurrentPrice -> Mocking
            )
        } //  가공된 객체 return
    }
}