package com.cyrius.middleware.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Test_Table")
class TestTable(id: Int, ready: Boolean, name: String) : BaseTable(id, ready, name){
    override fun sayHello() {
        println("Hello from Test_Table")
    }
}