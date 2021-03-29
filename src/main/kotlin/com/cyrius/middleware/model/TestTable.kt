package com.cyrius.middleware.model

import com.cyrius.middleware.`interface`.Interface
import com.cyrius.middleware.data.SedaptaInterfaceDC
import com.cyrius.middleware.properties.Properties
import com.google.gson.Gson
import org.springframework.context.annotation.Bean
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "Test_Table")
class TestTable(id: Int, ready: Boolean, name: String, processed: Boolean) : BaseTable(id, ready, name, processed){

    override fun process() {
        val body = Gson().toJson(SedaptaInterfaceDC("Test_Table", name))
        Interface().callInterface(body)
    }

}