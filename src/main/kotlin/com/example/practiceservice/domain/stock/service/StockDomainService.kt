package com.example.practiceservice.domain.stock.service

import com.example.practiceservice.domain.stock.model.Stock
import com.example.practiceservice.domain.stock.repository.StockRepository
import org.springframework.stereotype.Service

@Service
class StockDomainService(
    private val stockRepository: StockRepository
) {
    fun findStock(symbol: String): Stock {
        return stockRepository.findBySymbol(symbol)
    }

    fun findAllStocks(market: String): List<Stock>? {
        return stockRepository.findAllByMarket(market)
    }
}