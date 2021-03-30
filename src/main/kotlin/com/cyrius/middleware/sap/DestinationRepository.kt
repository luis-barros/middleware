package com.cyrius.middleware.sap

import com.sap.conn.jco.ext.DestinationDataProvider
import java.util.*

class DestinationRepository() {
    var properties = Properties()

    init {
        properties.setProperty(DestinationDataProvider.JCO_ASHOST, "192.168.1.157")
        properties.setProperty(DestinationDataProvider.JCO_SYSNR, "00")
        properties.setProperty(DestinationDataProvider.JCO_CLIENT, "001")
        properties.setProperty(DestinationDataProvider.JCO_USER, "DEVELOPER")
        properties.setProperty(DestinationDataProvider.JCO_PASSWD, "Appl1ance")
        properties.setProperty(DestinationDataProvider.JCO_LANG, "EN")
    }


    companion object {
        val CYRIUS_NPL: String  = "CYRIUS_NPL"

    }
}