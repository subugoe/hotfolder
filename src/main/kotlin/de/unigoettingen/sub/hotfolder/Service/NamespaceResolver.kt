package de.unigoettingen.sub.hotfolder.Service

import javax.xml.XMLConstants
import javax.xml.namespace.NamespaceContext

class NamespaceResolver() : NamespaceContext {

    override fun getNamespaceURI(prefix: String): String {

        val namespaceMapping = hashMapOf<String, String>(
                "gdz" to "http://gdz.sub.uni-goettingen.de/",
                "mets" to "http://www.loc.gov/METS/",
                "mods" to "http://www.loc.gov/mods/v3",
                "dv" to "http://dfg-viewer.de/",
                "xlink" to "http://www.w3.org/1999/xlink",
                "xsi" to "http://www.w3.org/2001/XMLSchema-instance",
                "schemaLocation" to "http://www.loc.gov/METS/ http://www.loc.gov/mets/mets.xsd http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods-3-2.xsd"
        )

        return namespaceMapping.getOrDefault(prefix, "mets")
    }

    override fun getPrefix(namespaceURI: String): String {

        val prefixMapping = hashMapOf<String, String>(
                "http://gdz.sub.uni-goettingen.de/" to "gdz",
                "http://gdz.sub.uni-goettingen.de/" to "gdz",
                "http://www.loc.gov/METS/" to "mets",
                "http://www.loc.gov/mods/v3" to "mods",
                "http://dfg-viewer.de/" to "dv",
                "http://www.w3.org/1999/xlink" to "xlink",
                "http://www.w3.org/2001/XMLSchema-instance" to "xsi",
                "http://www.loc.gov/METS/" to "schemaLocation",
                "http://www.loc.gov/mets/mets.xsd" to "schemaLocation",
                "http://www.loc.gov/mods/v3" to "schemaLocation",
                "http://www.loc.gov/standards/mods/v3/mods-3-2.xsd" to "schemaLocation"
        )

        return prefixMapping.getOrDefault(namespaceURI, XMLConstants.NULL_NS_URI)
    }

    override fun getPrefixes(namespaceURI: String): Iterator<*>? {
        return null
    }

}
