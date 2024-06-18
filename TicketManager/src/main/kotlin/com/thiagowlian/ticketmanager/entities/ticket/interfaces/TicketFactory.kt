package com.thiagowlian.ticketmanager.entities.ticket.interfaces

import com.thiagowlian.ticketmanager.entities.ticket.*
import com.thiagowlian.ticketmanager.entities.user.UserImplementation
import java.time.LocalDateTime

interface TicketFactory {
    fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation): Ticket

    fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String?): Ticket

    fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency): Ticket

    fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency, messages: HashSet<Message>): Ticket

    fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency, messages: HashSet<Message>, history: List<Change>): Ticket
}