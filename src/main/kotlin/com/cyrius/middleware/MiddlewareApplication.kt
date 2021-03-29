package com.cyrius.middleware

import com.cyrius.middleware.properties.Properties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
@EnableConfigurationProperties(Properties::class)
class MiddlewareApplication

fun main(args: Array<String>) {
	runApplication<MiddlewareApplication>(*args)
}





