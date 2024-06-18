package com.thiagowlian.ticketmanager.entities.ticket

enum class Urgency(var priorityMultiplier: Int) {
    URGENTE(10),
    ALTA(5),
    MEDIA(2),
    BAIXA(1)
}