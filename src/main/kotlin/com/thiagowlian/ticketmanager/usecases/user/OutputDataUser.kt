package com.thiagowlian.ticketmanager.usecases.user

import com.thiagowlian.ticketmanager.entities.ticket.Status
import com.thiagowlian.ticketmanager.entities.ticket.interfaces.Ticket
import com.thiagowlian.ticketmanager.entities.user.User
import com.thiagowlian.ticketmanager.entities.user.UserImplementation

data class OutputDataUser(val username: String, val userType: String) {
    constructor(user: User) : this(user.getUsername(), user.getUserType().name)
}
