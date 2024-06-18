package com.thiagowlian.ticketmanager.usecases.ticket

import com.thiagowlian.ticketmanager.entities.ticket.interfaces.Ticket

interface TicketPresenter {
    fun createSucess(ticket: Ticket): OutputDataTicket
    fun createFail()

}