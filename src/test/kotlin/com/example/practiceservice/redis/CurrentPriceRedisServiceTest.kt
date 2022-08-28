package com.example.practiceservice.redis

import com.example.practiceservice.domain.redis.dto.CurrentPrice
import com.example.practiceservice.domain.redis.dto.CurrentPriceRequest
import com.example.practiceservice.domain.redis.repository.CurrentPriceRedisRepository
import com.example.practiceservice.domain.redis.service.CurrentPriceRedisService
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import

@Import(value = [CurrentPriceRedisService::class, CurrentPriceRedisRepository::class, ObjectMapper::class])
class CurrentPriceRedisServiceTest: BaseRedisTest() {

    private val stockList: Map<String, CurrentPrice> = mapOf(
        "KAKAO" to CurrentPrice(50000.0),
        "KAKAOPAY" to CurrentPrice(67000.0),
        "BRAINZ" to CurrentPrice(50000.0),
    )

    @Autowired
    private lateinit var currentPriceRedisService: CurrentPriceRedisService

    @Autowired
    private lateinit var currentPriceRedisRepository: CurrentPriceRedisRepository

    @BeforeEach
    internal fun setUp() {
        stockList.forEach { (stock, price) ->
            currentPriceRedisRepository.put("KB", "KRW", stock, price)
        }
    }

    @Test
    internal fun `정상 조회 확인`() {
        val currentPrices = currentPriceRedisService.findCurrentPrice(
            CurrentPriceRequest("KB", "KRW", "KAKAO")
        )

        assertThat(currentPrices).isNotNull
        assertThat(currentPrices).isEqualTo(CurrentPrice(50000.0))
    }
}