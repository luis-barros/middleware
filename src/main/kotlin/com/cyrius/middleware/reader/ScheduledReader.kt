package com.cyrius.middleware.reader

import com.cyrius.middleware.repo.BaseTableRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledReader {

    @Autowired lateinit var repo: BaseTableRepository

    @Scheduled(fixedRate = 500)
    fun readAndUpdateReadyTables() {
        repo.findByReady(true).forEach {
            it.sayHello()
            it.ready = false
            repo.save(it)
        }
    }
}