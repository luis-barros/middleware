package com.cyrius.middleware.`interface`

import com.cyrius.middleware.sap.DestinationRepository
import com.cyrius.middleware.sap.InMemoryDestinationDataProvider
import com.sap.conn.jco.AbapException
import com.sap.conn.jco.JCoDestinationManager
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
@Configuration
@EnableConfigurationProperties()
class SAPRFCServiceInterface:SAPInterface {

    override fun callSAPInterface(body: String) {
        val destination = JCoDestinationManager.getDestination(DestinationRepository.CYRIUS_NPL)
        val function = destination.repository.getFunction(FUNCTION_NAME)
        function.importParameterList.setValue("TEST", "TEST123")
        if (function == null) {
            RuntimeException("$FUNCTION_NAME function not found in system")
        }
        try {
            function.execute(destination)
        } catch (e: AbapException) {
            println(e)
            return
        }
    }
    companion object {
        val FUNCTION_NAME = "ZTEST_REMOTE"
    }
}