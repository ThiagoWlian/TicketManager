package com.thiagowlian.ticketmanager.entities.ticket.interfaces

import com.thiagowlian.ticketmanager.entities.ticket.TicketImplementation
import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

interface Validation {
    fun executeValidation(ticketImplementation: TicketImplementation): ValidationResult
}