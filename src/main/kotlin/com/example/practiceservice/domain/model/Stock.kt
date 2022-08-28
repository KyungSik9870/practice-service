package com.example.practiceservice.domain.model

import com.example.practiceservice.domain.Audit
import javax.persistence.*

@Entity
class Stock(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    val id: Long,

    val stockName: String,
    val symbol: String,
    val market: String,
    val openPrice: Double,
    val endPrice: Double,
    val status: String
): Audit() {

}