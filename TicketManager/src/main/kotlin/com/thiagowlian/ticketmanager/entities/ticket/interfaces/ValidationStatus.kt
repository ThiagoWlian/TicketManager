package com.thiagowlian.ticketmanager.entities.ticket.interfaces

import com.thiagowlian.ticketmanager.entities.ticket.Status
import com.thiagowlian.ticketmanager.entities.ticket.TicketImplementation
import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

interface ValidationStatus : PreviusValidation, Validation {
    var previusStatus: Status?

    /**
     * Executa a validação do status atual e do predecessor
     *
     * Caso a função seja sobrescrita, deve manter a mesma lógia de executar a validação do status predecessor
     */
    fun executeValidationStatus(ticketImplementation: TicketImplementation): ValidationResult {
        val previusValidationResult = this.executePreviusValidation(previusStatus, ticketImplementation)
        if (previusValidationResult.isError()) {
            return previusValidationResult
        }
        return this.executeValidationStatus(ticketImplementation)
    }
}