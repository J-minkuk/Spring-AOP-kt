package com.example.aop.service.execution

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class KotlinService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    fun print() {
        logger.info("Kotlin")
    }
}
