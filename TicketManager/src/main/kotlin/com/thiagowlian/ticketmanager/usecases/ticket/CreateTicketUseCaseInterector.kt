package com.thiagowlian.ticketmanager.usecases.ticket

import com.thiagowlian.ticketmanager.entities.ticket.Status
import com.thiagowlian.ticketmanager.entities.ticket.interfaces.Ticket
import com.thiagowlian.ticketmanager.entities.ticket.interfaces.TicketFactory
import com.thiagowlian.ticketmanager.entities.user.UserImplementation

class CreateTicketUseCaseInterector(private val ticketFactory: TicketFactory, private val createTicketDataAcess: CreateTicketDataAcessInterface, private val ticketPresenter: TicketPresenter) : TicketInputBoundary {

    override fun createTicket(identificationCode: String, title: String, description: String?, status: Status, creator: Long): OutputDataTicket {

        val ticket = ticketFactory.create(identificationCode, title, status, creator, description)
        saveTicket(ticket)
        return ticketPresenter.createSucess(ticket)
    }

    private fun saveTicket(ticket: Ticket) {
        val outputDataTicket = OutputDataTicket(ticket)
        createTicketDataAcess.save(outputDataTicket)
    }
}