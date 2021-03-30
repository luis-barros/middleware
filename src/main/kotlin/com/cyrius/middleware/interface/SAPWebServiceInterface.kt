package com.cyrius.middleware.`interface`

import com.cyrius.middleware.properties.ApplicationProperties
import okhttp3.Credentials
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
@Configuration
@EnableConfigurationProperties()
class SAPWebServiceInterface (): SAPInterface{

    @Autowired
    lateinit var applicationProperties: ApplicationProperties

    override fun callSAPInterface(body:String) {
        val credential = Credentials.basic(applicationProperties.username, applicationProperties.password)
        val request = Request.Builder()
            .url("http://192.168.1.157:8000/sedapta/test1?sap-client=001")
            .header("Authorization", credential)
            .post(body.toRequestBody(MEDIA_TYPE_APPLICATION_JSON))
            .build()

        OkHttpClient().newCall(request).execute()
    }

    companion object {
        private val MEDIA_TYPE_APPLICATION_JSON = "application/json; charset=utf-8".toMediaType()
    }
}