package com.example.practiceservice.api.stock.service

import com.example.practiceservice.api.stock.response.StockResponse
import com.example.practiceservice.api.stock.response.StockResponses
import com.example.practiceservice.domain.stock.service.StockDomainService
import org.springframework.stereotype.Service

@Service
class StockService(
    private val stockDomainService: StockDomainService,
    private val stockCurrentPriceService: StockCurrentPriceService
) {
    fun findStock(symbol: String): StockResponse {
        return stockDomainService.findStock(symbol)
            .let { stockCurrentPriceService.findCurrentPrice(it) }
            .let { StockResponse.of(it) }
    }


    fun findStocks(market: String): StockResponses {
        return stockDomainService.findAllStocks(market) // list - 딜리버리 -> Mocking
            .let { stockCurrentPriceService.findCurrentPriceWithAll(it!!) } // list - 가공 -> Mocking
            .let { StockResponses.of(it) }
    }

}