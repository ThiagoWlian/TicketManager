package com.thiagowlian.ticketmanager.interfaceAdapter.controller

import com.thiagowlian.ticketmanager.interfaceAdapter.controller.request.CreateTicketRequest
import com.thiagowlian.ticketmanager.usecases.ticket.TicketInputBoundary
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ticket")
class TicketController(val ticketInputBoundary: TicketInputBoundary) {

    @PostMapping
    fun createTicket(@Valid createTicketRequest: CreateTicketRequest) {
        ticketInputBoundary.createTicket(
                createTicketRequest.identificationCode,
                createTicketRequest.title,
                createTicketRequest.description,
                createTicketRequest.status,
                createTicketRequest.userCreator
        )
    }
}