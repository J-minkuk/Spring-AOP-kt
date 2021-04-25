package com.example.aop.common

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class PrintAspect {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Pointcut("execution(* com.example.aop.service.execution.KotlinService.print(..))")
    private fun kotlinPrint() {
    }

    @Pointcut("execution(* com.example.aop.service.execution.KotlinService.exception(..))")
    private fun kotlinException() {
    }

    @Pointcut("execution(* com.example.aop.service.execution.JavaService.print(..))")
    private fun javaPrint() {
    }

    @Pointcut("@annotation(com.example.aop.service.annotate.JsCustom)")
    private fun jsPrint() {
    }

    @Before("kotlinPrint()")
    fun beforePrint() {
        logger.info("Before Kotlin Print")
    }

    @After("javaPrint()")
    fun afterPrint() {
        logger.info("After Java Print")
    }

    @AfterThrowing(pointcut = "kotlinException()", throwing = "exception")
    fun afterThrow(exception: IllegalArgumentException) {
        logger.info("After IllegalArgumentException ${exception.message}")
        throw IllegalArgumentException("AOP Throw")
    }

    @Around("jsPrint()")
    fun aroundPrint(pjp: ProceedingJoinPoint): String {
        logger.info("Around JS Print")
        val message = pjp.proceed()
        logger.info(message.toString())
        return "$message RESULT"
    }

}
