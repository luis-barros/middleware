package com.cyrius.middleware

import com.cyrius.middleware.properties.ApplicationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
@EnableConfigurationProperties(ApplicationProperties::class)
class MiddlewareApplication

fun main(args: Array<String>) {
	runApplication<MiddlewareApplication>(*args)
}





