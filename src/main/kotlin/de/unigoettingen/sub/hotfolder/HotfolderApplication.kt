package de.unigoettingen.sub.hotfolder

import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HotfolderApplication {
}

fun main(args: Array<String>) {
        val app = SpringApplication(HotfolderApplication::class.java)
            app.setBannerMode(Banner.Mode.OFF)
            app.isWebEnvironment = false
            app.run(*args)
}
