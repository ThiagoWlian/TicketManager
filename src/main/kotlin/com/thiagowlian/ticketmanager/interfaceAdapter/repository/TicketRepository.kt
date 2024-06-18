package com.thiagowlian.ticketmanager.interfaceAdapter.repository

import com.thiagowlian.ticketmanager.entities.ticket.interfaces.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : JpaRepository<Ticket, String>