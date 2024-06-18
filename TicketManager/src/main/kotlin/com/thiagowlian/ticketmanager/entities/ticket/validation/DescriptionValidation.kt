package br.com.thiagowlian.TicketManager.model.validation

import com.thiagowlian.ticketmanager.entities.ticket.TicketImplementation
import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

class DescriptionValidation(var ticketImplementation: TicketImplementation) : BaseValidation<TicketImplementation>(ticketImplementation) {
    override fun isValid(): ValidationResult {
        if (ticketImplementation.description == null) {
            return ValidationResult.createError("Não existe descrição para o ticket!")
        }
        return startNextValidation()
    }
}