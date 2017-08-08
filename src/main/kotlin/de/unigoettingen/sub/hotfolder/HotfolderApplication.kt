package de.unigoettingen.sub.hotfolder

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HotfolderApplication

fun main(args: Array<String>) {
    SpringApplication.run(HotfolderApplication::class.java, *args)
}
