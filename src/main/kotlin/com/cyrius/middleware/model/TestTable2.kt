package com.cyrius.middleware.model

import com.cyrius.middleware.`interface`.Interface
import com.cyrius.middleware.properties.Properties
import org.springframework.context.ApplicationContext
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.context.annotation.AnnotationConfigApplicationContext




@Entity
@Table(name = "table2")
class TestTable2(id: Int, ready: Boolean, name: String, processed: Boolean) : BaseTable(id, ready, name, processed){
    override fun process() {
        Interface().callInterface("test")
        println("Hello from table2 test")
    }
}