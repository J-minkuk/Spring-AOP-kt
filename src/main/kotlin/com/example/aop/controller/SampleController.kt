package com.example.aop.controller

import com.example.aop.service.annotate.JavascriptService
import com.example.aop.service.execution.JavaService
import com.example.aop.service.execution.KotlinService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    private val kotlinService: KotlinService,
    private val javaService: JavaService,
    private val javascriptService: JavascriptService,
) {
    @GetMapping("test")
    fun print(): String {
        kotlinService.print()
        javaService.print()
        return javascriptService.print()
    }

    @GetMapping("exception")
    fun exception() {
        kotlinService.exception()
    }
}
