package br.com.thiagowlian.TicketManager.model.validation

import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

abstract class BaseValidation<T>(var entity: T) {
    private var nextValidation: BaseValidation<T>? = null

    /**
     * Utilizado para executar a validação
     *
     * A implementação dessa função sempre deve executar o startNextValidation e retornar o seu valor.
     */
    abstract fun isValid() : ValidationResult

    fun setNextValidation(validation: BaseValidation<T>): BaseValidation<T> {
        nextValidation = validation
        return nextValidation!!
    }

    protected fun startNextValidation(): ValidationResult {
        nextValidation?.run {
            this.isValid()
        }
        return ValidationResult.createSucess()
    }

    protected fun nextValidationsExists(): Boolean {
        return nextValidation != null
    }
}