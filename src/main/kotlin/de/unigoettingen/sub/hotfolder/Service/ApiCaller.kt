package de.unigoettingen.sub.hotfolder.Service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ApiCaller {

    fun informAboutNewWork(id: String): String {
        LoggerFactory.getLogger("ApiCaller").info("Informed API about ${id}")

        return id
    }

}
