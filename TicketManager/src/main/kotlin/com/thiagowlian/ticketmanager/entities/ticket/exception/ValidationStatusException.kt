package com.thiagowlian.ticketmanager.entities.ticket.exception

import com.thiagowlian.ticketmanager.entities.ticket.validation.ValidationResult

class ValidationStatusException(var validationResult: ValidationResult) : RuntimeException()