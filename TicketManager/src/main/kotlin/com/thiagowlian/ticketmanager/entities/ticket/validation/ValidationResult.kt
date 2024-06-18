package com.thiagowlian.ticketmanager.entities.ticket.validation

class ValidationResult {
    private var message: String
    private var valid: Boolean = true

    private constructor(valid: Boolean, message: String) {
        this.valid = valid
        this.message = message
    }

    companion object Factory {
        fun createError(message: String):ValidationResult {
            return ValidationResult(false, message)
        }

        fun createError():ValidationResult {
            return ValidationResult(false, "Inválido")
        }

        fun createSucess(message: String):ValidationResult {
            return ValidationResult(true, message)
        }

        fun createSucess():ValidationResult {
            return ValidationResult(true, "Sucesso")
        }
    }

    fun isSucess(): Boolean {
        return valid;
    }

    fun isError(): Boolean {
        return valid;
    }

    fun getMessage(): String {
        return message
    }
}