package com.github.fanasa.demokotlinwebapp

import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class Patron(

        @Column(name = "first_name")
        val firstName: String,

        @Column(name = "last_name")
        val lastName: String,

        @Column(name = "email")
        val email: String,

        @Column(name = "handle")
        val handle: String? = "@$firstName$lastName",

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
)
