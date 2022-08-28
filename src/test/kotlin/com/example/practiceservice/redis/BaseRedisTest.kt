package com.example.practiceservice.redis

import com.example.practiceservice.domain.config.EmbeddedRedisConfig
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest
import org.springframework.context.annotation.Import

@DataRedisTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Import(value = [EmbeddedRedisConfig::class])
abstract class BaseRedisTest {
}