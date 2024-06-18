package com.thiagowlian.ticketmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TicketManagerApplication

fun main(args: Array<String>) {
    runApplication<TicketManagerApplication>(*args)
}
