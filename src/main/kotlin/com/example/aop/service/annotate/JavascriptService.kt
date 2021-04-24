package com.example.aop.service.annotate

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class JavascriptService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @JsCustom
    fun print(): String {
        logger.info("Javascript")
        return "JS"
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class JsCustom
