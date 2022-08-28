package com.example.practiceservice.domain.repository

import com.example.practiceservice.domain.model.Stock
import org.springframework.data.repository.CrudRepository

interface StockRepository : CrudRepository<Stock, Long> {
    fun findBySymbol(symbol: String): Stock
}