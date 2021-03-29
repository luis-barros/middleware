package com.cyrius.middleware.`interface`

import com.cyrius.middleware.model.BaseTable
import com.cyrius.middleware.properties.Properties
import okhttp3.Credentials
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.EnableTransactionManagement

@Component
@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(Properties::class)
class Interface (){

    @Autowired
    lateinit var properties: Properties

    fun callInterface(body:String) {
        println(properties.username +" " + properties.password)
        val client = OkHttpClient()
        val credential = Credentials.basic(properties.username, properties.password)
        val request = Request.Builder()
            .url(properties.url)
            .header("Authorization", credential)
            .post(body.toRequestBody(MEDIA_TYPE_APPLICATION_JSON))
            .build()

        client.newCall(request).execute()
    }

    companion object {
        private val MEDIA_TYPE_APPLICATION_JSON = "application/json; charset=utf-8".toMediaType()
    }
}