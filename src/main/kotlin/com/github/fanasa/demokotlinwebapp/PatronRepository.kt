package com.github.fanasa.demokotlinwebapp

import org.springframework.data.jpa.repository.JpaRepository

interface PatronRepository : JpaRepository<Patron, Long> {

    fun findByHandle(handle: String) : Patron?
}
