package com.cyrius.middleware.repo

import com.cyrius.middleware.model.BaseTable
import org.springframework.data.repository.CrudRepository

interface BaseTableRepository : CrudRepository<BaseTable, Int>{
    fun findByReady(ready: Boolean): Iterable<BaseTable>
}