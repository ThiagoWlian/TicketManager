package com.thiagowlian.ticketmanager.usecases.ticket

import com.thiagowlian.ticketmanager.entities.ticket.Status
import com.thiagowlian.ticketmanager.entities.ticket.interfaces.Ticket
import com.thiagowlian.ticketmanager.entities.user.UserImplementation

data class OutputDataTicket(val identificationCode: String, val title: String, val status: Status, val creator: UserImplementation) {
    constructor(ticket: Ticket) : this(ticket.getIdentificationCode(), ticket.getTitle(), ticket.getStatus(), ticket.getCreator())
}
