package com.thiagowlian.ticketmanager.entities.ticket.interfaces

import com.thiagowlian.ticketmanager.entities.ticket.Status
import com.thiagowlian.ticketmanager.entities.ticket.TicketImplementation
import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

interface PreviusValidation {
    fun executePreviusValidation(previusStatus: Status?, ticketImplementation: TicketImplementation): ValidationResult {
        return previusStatus?.executeValidationStatus(ticketImplementation) ?: ValidationResult.createSucess()
    }
}