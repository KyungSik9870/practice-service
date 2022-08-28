package com.example.practiceservice.service

import com.example.practiceservice.domain.model.CurrentPrice
import com.example.practiceservice.domain.model.CurrentPriceRequest
import com.example.practiceservice.domain.model.Stock
import com.example.practiceservice.domain.repository.CurrentPriceRedisRepository
import com.example.practiceservice.domain.repository.StockRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Spy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StockServiceTest {

    @Autowired
    private lateinit var stockService: StockService

    @Autowired
    private lateinit var stockRepository: StockRepository

    @Autowired
    private lateinit var currentPriceRepository: CurrentPriceRedisRepository

    @Autowired
    private lateinit var currentPriceRedisService: CurrentPriceRedisService

    private val stockList: Map<String, CurrentPrice> = mapOf(
        "KAKAO" to CurrentPrice(50000.0),
        "KAKAOPAY" to CurrentPrice(67000.0),
        "BRAINZ" to CurrentPrice(50000.0),
    )

    @BeforeEach
    internal fun setUp() {
        stockList.forEach { (stock, price) ->
            currentPriceRepository.put("KB", "KRW", stock, price)
        }

        stockRepository.save(
            Stock(1, "KB", "KRW", "KAKAOPAY", 67000.0, 67800.0, "FINE")
        )
    }

    @Test
    internal fun name() {
        assertThat(stockService.findStock("KAKAOPAY")).isEqualTo(CurrentPrice(67000.0))
    }
}