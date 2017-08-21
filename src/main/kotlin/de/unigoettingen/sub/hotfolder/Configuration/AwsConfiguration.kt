package de.unigoettingen.sub.hotfolder.Configuration

import org.jetbrains.annotations.NotNull
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "app.aws")
class AwsConfiguration {
    @NotNull lateinit var url: String
    @NotNull lateinit var access: String
    @NotNull lateinit var secret: String
    @NotNull lateinit var bucket: String
}
