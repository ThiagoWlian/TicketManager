package com.thiagowlian.ticketmanager.entities.ticket.interfaces

import com.thiagowlian.ticketmanager.entities.ticket.Change
import com.thiagowlian.ticketmanager.entities.ticket.Message
import com.thiagowlian.ticketmanager.entities.ticket.Status
import com.thiagowlian.ticketmanager.entities.ticket.Urgency
import com.thiagowlian.ticketmanager.entities.user.UserImplementation
import java.time.LocalDate
import java.time.LocalDateTime

interface Ticket {
    fun getIdentificationCode(): String

    fun getTitle(): String

    fun getDescription(): String?

    fun getCreationDate(): LocalDate

    fun getStatus(): Status

    fun getCreator(): UserImplementation

    fun getUrgency(): Urgency?

    fun getResponsible(): UserImplementation?

    fun getMessages(): MutableSet<Message>

    fun getStartDateTime(): LocalDateTime?

    fun getHistory(): List<String>

    fun getPriority(): Int

    fun changeStatus(status: Status, userImplementation: UserImplementation)

    fun changeDescription(description: String, userImplementation: UserImplementation)

    fun changeTitle(title: String, userImplementation: UserImplementation)

    fun changeResponsible(responsible: UserImplementation, userImplementation: UserImplementation)

    fun comment(identificationCode: String, message: String, userImplementation: UserImplementation)

    fun removeComment(identificationCode: String)
}