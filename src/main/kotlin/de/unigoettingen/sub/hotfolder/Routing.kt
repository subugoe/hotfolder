package de.unigoettingen.sub.hotfolder

import org.apache.camel.builder.RouteBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix="app.source")
class Routing:RouteBuilder() {

    var hostname: String = ""
    var username: String = ""
    var password: String = ""
    var path: String = ""
    var target: String = ""

    @Throws(Exception::class)
        override fun configure() {
            from("sftp://${username}@${hostname}${path}?password=${password}&idempotent=true&readLock=changed")
                .to(target)
                .to("bean:de.unigoettingen.sub.hotfolder.Service.IdRetriever?method=getId")
                .to("bean:de.unigoettingen.sub.hotfolder.Service.ImageWriter?method=writeImages")
                .to("bean:de.unigoettingen.sub.hotfolder.Service.ApiCaller?method=informAboutNewWork")
        }
}
