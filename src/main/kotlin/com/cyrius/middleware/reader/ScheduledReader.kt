package com.cyrius.middleware.reader

import com.cyrius.middleware.`interface`.SAPIDocServiceInterface
import com.cyrius.middleware.`interface`.SAPRFCServiceInterface
import com.cyrius.middleware.`interface`.SAPWebServiceInterface
import com.cyrius.middleware.repo.BaseTableRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledReader {

    @Autowired lateinit var repo: BaseTableRepository
    @Autowired lateinit var sapInterface: SAPIDocServiceInterface

    @Scheduled(fixedRate = 500)
    fun readAndUpdateReadyTables() {
        repo.findByReadyTrueAndProcessedFalse().forEach {
            sapInterface.callSAPInterface(it.getTableDataInJSON())
            it.processed = true
            repo.save(it)
        }
    }
}