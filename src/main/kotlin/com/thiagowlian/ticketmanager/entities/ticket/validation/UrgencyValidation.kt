package br.com.thiagowlian.TicketManager.model.validation

import com.thiagowlian.ticketmanager.entities.ticket.TicketImplementation
import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

class UrgencyValidation(var ticketImplementation: TicketImplementation) : BaseValidation<TicketImplementation>(ticketImplementation) {
    override fun isValid(): ValidationResult {
        if (ticketImplementation.urgency == null) {
            return ValidationResult.createError("Não existe urgência para o ticket!")
        }
        return startNextValidation()
    }
}