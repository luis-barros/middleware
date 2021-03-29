package com.cyrius.middleware.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "table2")
class TestTable2(id: Int, ready: Boolean, name: String, processed: Boolean) : BaseTable(id, ready, name, processed){
    override fun sayHello() {
        println("Hello from table2 test")
    }
}