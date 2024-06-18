package com.thiagowlian.ticketmanager.interfaceAdapter.dataacess

import com.thiagowlian.ticketmanager.entities.user.User
import com.thiagowlian.ticketmanager.interfaceAdapter.mapper.ticket.TicketDataMapper
import com.thiagowlian.ticketmanager.interfaceAdapter.repository.TicketRepository
import com.thiagowlian.ticketmanager.usecases.ticket.CreateTicketDataAcessInterface
import com.thiagowlian.ticketmanager.usecases.ticket.OutputDataTicket
import org.springframework.beans.factory.annotation.Autowired

class TicketDataAcess(val ticketRepository: TicketRepository) : CreateTicketDataAcessInterface {

    override fun save(outputDataTicket: OutputDataTicket) {
        var user = User()
        var ticketDataMapper = TicketDataMapper(
                outputDataTicket.identificationCode,
                outputDataTicket.title,
                outputDataTicket.status,
                outputDataTicket.creator
        )
        ticketRepository.save()
    }
}