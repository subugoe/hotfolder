package de.unigoettingen.sub.hotfolder.Service

import de.unigoettingen.sub.hotfolder.Configuration.AwsConfiguration
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ImageWriter {

    @Autowired
    lateinit var awsConfiguration: AwsConfiguration

    fun writeImages(directory: String): String {
        LoggerFactory.getLogger("ImageWriter").info("Wrote ${directory}")

        return directory
    }

}
