package com.github.fanasa.demokotlinwebapp

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class GreetingsController(private val patronRepository: PatronRepository) {

    @GetMapping("/greet/{handle}")
    fun greet(@PathVariable("handle") handle: String) : ResponseEntity<String> {
        val foundPatron = this.patronRepository.findByHandle(handle)
        val greetingMessage: String = if(foundPatron != null) "Hello ${foundPatron.firstName}, we will contact you shortly on your email recorded as ${foundPatron.email}" else "No one is registered with handle $handle"
        return ResponseEntity.ok(greetingMessage)
    }

    @GetMapping("/patron/{id}")
    fun getPatron(@PathVariable("id") id: Long) : ResponseEntity<Optional<Patron>> {
        val foundPatron = this.patronRepository.findById(id)
        return ResponseEntity.ok(foundPatron)
    }

    @PostMapping("/patron")
    fun createNewPatron(@RequestBody newPatron: Patron) : ResponseEntity<Long> {
        val savedPatron = patronRepository.save(newPatron)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatron.id)
    }
}
