package com.cyrius.middleware.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component


@ConstructorBinding
@ConfigurationProperties(prefix = "sap")
data class ApplicationProperties(
    val username: String,
    var password: String,
    var url: String
)
