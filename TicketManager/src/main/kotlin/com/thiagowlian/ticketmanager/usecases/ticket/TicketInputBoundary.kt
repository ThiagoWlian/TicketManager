package com.thiagowlian.ticketmanager.usecases.ticket

import com.thiagowlian.ticketmanager.entities.ticket.Status
import com.thiagowlian.ticketmanager.entities.user.UserImplementation

interface TicketInputBoundary {
    fun createTicket(identificationCode: String, title: String, description: String?, status: Status, creator: Long): OutputDataTicket
}