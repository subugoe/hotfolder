package de.unigoettingen.sub.hotfolder.Service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

@Component
class IdRetriever {

    @Autowired
    lateinit var writer: Writer

    fun getId(content: String): String {
        val xpaths = ArrayList<String>()
        xpaths.add("/mets:mets/mets:dmdSec/mets:mdWrap[@MDTYPE=\"MODS\"]/mets:xmlData/mods:mods[1]/mods:identifier[@type=\"gbv-ppn\"]")
        xpaths.add("/mets:mets/mets:dmdSec/mets:mdWrap[@MDTYPE=\"MODS\"]/mets:xmlData/mods:mods[1]/mods:identifier[@type=\"ppn\" or @type=\"PPN\"]")
        xpaths.add("/mets:mets/mets:dmdSec/mets:mdWrap[@MDTYPE=\"MODS\"]/mets:xmlData/mods:mods[1]/mods:identifier[@type=\"urn\" or @type=\"URN\"]")
        xpaths.add("/mets:mets/mets:dmdSec/mets:mdWrap[@MDTYPE=\"MODS\"]/mets:xmlData/mods:mods[1]/mods:recordInfo/mods:recordIdentifier[@source=\"Kalliope\"]")
        xpaths.add("/mets:mets/mets:dmdSec/mets:mdWrap[@MDTYPE=\"MODS\"]/mets:xmlData/mods:mods[1]/mods:identifier[@type=\"local\"][not(@invalid=\"yes\")]")
        xpaths.add("/mets:mets/mets:dmdSec/mets:mdWrap[@MDTYPE=\"MODS\"]/mets:xmlData/mods:mods[1]/mods:recordInfo/mods:recordIdentifier")

        val dbi = DocumentBuilderFactory.newInstance()
        dbi.setNamespaceAware(true)
        val xmlDocument = dbi.newDocumentBuilder().parse(InputSource(StringReader(content)))
        val xPathProcessor = XPathFactory.newInstance().newXPath()
        xPathProcessor.setNamespaceContext(NamespaceResolver())

        for (xpath in xpaths) {
            try {
                val nodeList = xPathProcessor.evaluate(xpath, xmlDocument, XPathConstants.NODESET) as NodeList

                if (nodeList.length > 0) {
                    val value = nodeList.item(0).firstChild.nodeValue
                    LoggerFactory.getLogger("idGenerator").info(value)

                    writer.writeFile(value, content)

                    return value
                } else {
                    continue
                }
            } catch (e: Exception) {
                LoggerFactory.getLogger("idGenerator").error(e.message)
            }
        }
        return ""
    }


}
