package com.cyrius.middleware.model

import com.cyrius.middleware.`interface`.SAPInterface
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class BaseTable(@Id open var id: Int, open var ready: Boolean, open var name: String,
                        open var processed: Boolean) {

    abstract fun getTableDataInJSON(): String
}
