package com.cyrius.middleware.`interface`

import com.sap.conn.idoc.IDocFactory
import com.sap.conn.idoc.jco.JCoIDoc
import com.sap.conn.jco.JCoDestinationManager
import org.springframework.stereotype.Component

@Component
class SAPIDocServiceInterface:SAPInterface {
    override fun callSAPInterface(body: String) {
        val destination = JCoDestinationManager.getDestination(CYRIUS_NPL)
        val idocRepo = JCoIDoc.getIDocRepository(destination)
        val tid = destination.createTID()
        val idocFactory = JCoIDoc.getIDocFactory()

        var idoc = idocFactory.createIDocDocument(idocRepo, "CHARACTERISTIC_CREATE01")
        var root = idoc.rootSegment
        var E1CHARACTERISTIC_CREATE = root.addChild("E1CHARACTERISTIC_CREATE")
        var E1BPCHARACTDETAIL = E1CHARACTERISTIC_CREATE.addChild("E1BPCHARACTDETAIL")
        E1BPCHARACTDETAIL.setValue("CHARACT_NAME", "Test123")
        E1BPCHARACTDETAIL.setValue("DATA_TYPE", "CHAR")
        E1BPCHARACTDETAIL.setValue("LENGTH", 10)

        JCoIDoc.send(idoc, IDocFactory.IDOC_VERSION_DEFAULT, destination, tid)
    }

    companion object {
        val CYRIUS_NPL = "CYRIUS_NPL"
    }
}