package com.cyrius.middleware.model

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
open class BaseTable(@Id open var id: Int, open var ready: Boolean, open var name: String) {
    open fun sayHello() {}
}