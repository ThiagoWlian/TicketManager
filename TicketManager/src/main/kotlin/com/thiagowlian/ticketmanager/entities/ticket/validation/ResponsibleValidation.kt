package br.com.thiagowlian.TicketManager.model.validation

import com.thiagowlian.ticketmanager.entities.ticket.TicketImplementation
import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

class ResponsibleValidation(var ticketImplementation: TicketImplementation) : BaseValidation<TicketImplementation>(ticketImplementation) {
    override fun isValid(): ValidationResult {
        if (ticketImplementation.responsible == null) {
            return ValidationResult.createError("Nenhum responsável foi atribuído ao ticket!")
        }
        return startNextValidation()
    }
}