package com.cyrius.middleware.model

import com.cyrius.middleware.data.SedaptaInterfaceDC
import com.google.gson.Gson
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "Test_Table")
class TestTable(id: Int, ready: Boolean, name: String, processed: Boolean) : BaseTable(id, ready, name, processed){

    override fun getTableDataInJSON(): String {
        return Gson().toJson(SedaptaInterfaceDC("Test_Table", name))
    }

}