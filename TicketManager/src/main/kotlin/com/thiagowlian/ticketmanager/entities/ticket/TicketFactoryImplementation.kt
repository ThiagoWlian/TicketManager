package com.thiagowlian.ticketmanager.entities.ticket

import com.thiagowlian.ticketmanager.entities.ticket.interfaces.Ticket
import com.thiagowlian.ticketmanager.entities.ticket.interfaces.TicketFactory
import com.thiagowlian.ticketmanager.entities.user.UserImplementation
import java.time.LocalDateTime

class TicketFactoryImplementation : TicketFactory {
    override fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation): Ticket {
        return TicketImplementation(identificationCode, title, status, creator)
    }

    override fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String): Ticket {
        return TicketImplementation(identificationCode, title, status, creator, description)
    }

    override fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency): Ticket {
        return TicketImplementation(identificationCode, title, status, creator, description, responsible, startDateTime, urgency)
    }

    override fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency, messages: HashSet<Message>): Ticket {
        return TicketImplementation(identificationCode, title, status, creator, description, responsible, startDateTime, urgency, messages)
    }

    override fun create(identificationCode: String, title: String, status: Status, creator: UserImplementation, description: String, responsible: UserImplementation, startDateTime: LocalDateTime, urgency: Urgency, messages: HashSet<Message>, history: List<Change>): Ticket {
        return TicketImplementation(identificationCode, title, status, creator, description, responsible, startDateTime, urgency, messages, history)
    }
}