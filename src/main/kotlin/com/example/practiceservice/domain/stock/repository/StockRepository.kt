package com.example.practiceservice.domain.stock.repository

import com.example.practiceservice.domain.stock.model.Stock
import org.springframework.data.repository.CrudRepository

interface StockRepository : CrudRepository<Stock, Long> {
    fun findBySymbol(symbol: String): Stock
    fun findAllByMarket(market: String): List<Stock>
}