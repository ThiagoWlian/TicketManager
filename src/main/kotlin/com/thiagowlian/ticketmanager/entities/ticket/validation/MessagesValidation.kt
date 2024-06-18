package br.com.thiagowlian.TicketManager.model.validation

import com.thiagowlian.ticketmanager.entities.ticket.TicketImplementation
import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

class MessagesValidation(var ticketImplementation: TicketImplementation) : BaseValidation<TicketImplementation>(ticketImplementation) {
    override fun isValid(): ValidationResult {
        if (ticketImplementation.messages.isEmpty()) {
            return ValidationResult.createError("Nenhum comentário foi atribuído ao ticket!")
        }
        return startNextValidation()
    }
}