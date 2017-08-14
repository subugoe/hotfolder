package de.unigoettingen.sub.hotfolder.Configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("app.aws")
open class AwsConfiguration {

    var url: String = ""
    var access: String = ""
    var secret: String = ""
    var bucket: String = ""

}
