package com.github.fanasa.demokotlinwebapp

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoKotlinWebAppApplication {

	private val log = LoggerFactory.getLogger(DemoKotlinWebAppApplication::class.java)

	@Bean
	fun initializeData(patronRepository: PatronRepository) = CommandLineRunner {
		patronRepository.save(Patron("Kevin", "Smith", "kevins@email.com"))
		patronRepository.save(Patron("John", "Doe", "johnd@email.com"))
		log.info("Done initializing the database")
	}
}

fun main(args: Array<String>) {
	runApplication<DemoKotlinWebAppApplication>(*args)
}
