package com.example.practiceservice.domain.model

import com.example.practiceservice.domain.Audit
import javax.persistence.*

@Entity
class Stock(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    val id: Long,

    val exchange: String,
    val market: String,
    val symbol: String,
    val openPrice: Double,
    val endPrice: Double,
    val status: String
): Audit() {

}