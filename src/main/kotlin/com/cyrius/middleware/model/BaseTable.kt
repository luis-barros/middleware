package com.cyrius.middleware.model

import com.cyrius.middleware.properties.Properties
import okhttp3.Credentials
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class BaseTable(@Id open var id: Int, open var ready: Boolean, open var name: String,
                        open var processed: Boolean) {

    abstract fun process()


}
