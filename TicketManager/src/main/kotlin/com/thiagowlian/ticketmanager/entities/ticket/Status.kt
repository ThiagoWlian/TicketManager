package com.thiagowlian.ticketmanager.entities.ticket

import br.com.thiagowlian.TicketManager.model.validation.MessagesValidation
import br.com.thiagowlian.TicketManager.model.validation.ResponsibleValidation
import br.com.thiagowlian.TicketManager.model.validation.UrgencyValidation
import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult
import com.thiagowlian.ticketmanager.entities.ticket.interfaces.ValidationStatus

enum class Status(var nameExibicao: String, override var previusStatus: Status?) : ValidationStatus {
    ABERTO("Aberto", null) {
        override fun executeValidation(ticketImplementation: TicketImplementation): ValidationResult {
            return ValidationResult.createSucess()
        }
    },
    PRONTO("Pronto", ABERTO) {
        override fun executeValidation(ticketImplementation: TicketImplementation): ValidationResult {
            return ValidationResult.createSucess()
        }
    },
    EM_ANDAMENTO("Em Andamento", PRONTO) {
        override fun executeValidation(ticketImplementation: TicketImplementation): ValidationResult {
            return ResponsibleValidation(ticketImplementation).setNextValidation(UrgencyValidation(ticketImplementation)).isValid()
        }
    },
    EM_TESTE("Em Teste", EM_ANDAMENTO) {
        override fun executeValidation(ticketImplementation: TicketImplementation): ValidationResult {
            return ValidationResult.createSucess()
        }
    },
    FINALIZADO("Finalizado", EM_TESTE) {
        override fun executeValidation(ticketImplementation: TicketImplementation): ValidationResult {
            return MessagesValidation(ticketImplementation).isValid()
        }
    };

    fun isEmAndamento(): Boolean {
        return this == EM_ANDAMENTO
    }
}