package com.cyrius.middleware.sap

import com.sap.conn.jco.ext.DataProviderException
import com.sap.conn.jco.ext.DestinationDataEventListener
import com.sap.conn.jco.ext.DestinationDataProvider
import java.util.*

class InMemoryDestinationDataProvider: DestinationDataProvider {
    private var eL: DestinationDataEventListener? = null
    private val secureDBStorage = HashMap<String, Properties>()
    override fun getDestinationProperties(destinationName: String): Properties {
        val p = secureDBStorage[destinationName]
        if (p.isNullOrEmpty()) {
            throw DataProviderException(DataProviderException.Reason.INVALID_CONFIGURATION,
                "Invalid destination", null)
        }
        return secureDBStorage[destinationName]!!
    }

    override fun supportsEvents(): Boolean {
        return false;
    }

    override fun setDestinationDataEventListener(destinationEventListener: DestinationDataEventListener?) {
        this.eL = destinationEventListener
    }
}
