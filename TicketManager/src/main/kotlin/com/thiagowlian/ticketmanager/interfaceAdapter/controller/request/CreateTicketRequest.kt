package com.thiagowlian.ticketmanager.interfaceAdapter.controller.request

import com.thiagowlian.ticketmanager.entities.ticket.Status
import jakarta.validation.constraints.NotBlank

data class CreateTicketRequest(@NotBlank val identificationCode: String,
                               @NotBlank val title: String,
                               val description: String?,
                               @NotBlank val status: Status,
                               @NotBlank val userCreator: Long)
