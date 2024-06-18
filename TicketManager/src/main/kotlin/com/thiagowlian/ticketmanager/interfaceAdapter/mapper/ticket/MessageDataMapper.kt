package com.thiagowlian.ticketmanager.interfaceAdapter.mapper.ticket

import com.thiagowlian.ticketmanager.entities.user.UserImplementation
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "message")
data class MessageDataMapper(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var identificationCode: String,
        @Column(name = "message")
        var message: String,
        @Column(name = "author")
        val author: UserImplementation,
        @Column(name = "creation_date")
        var creationDate: LocalDateTime
)
