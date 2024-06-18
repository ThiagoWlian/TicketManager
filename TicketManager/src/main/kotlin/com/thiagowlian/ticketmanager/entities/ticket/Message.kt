package com.thiagowlian.ticketmanager.entities.ticket

import com.thiagowlian.ticketmanager.entities.user.UserImplementation
import java.time.Duration
import java.time.LocalDateTime

data class Message(
        var identificationCode: String,
        var message: String,
        val author: UserImplementation,
        var creationDate: LocalDateTime = LocalDateTime.now()
) {
    fun getDaysAfterComment() : Duration {
        return Duration.between(creationDate, LocalDateTime.now())
    }

    override fun equals(other: Any?): Boolean {
        other as Message
        return identificationCode == other.identificationCode
    }
}