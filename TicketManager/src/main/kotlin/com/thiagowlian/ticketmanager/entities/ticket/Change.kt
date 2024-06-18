package com.thiagowlian.ticketmanager.entities.ticket

import com.thiagowlian.ticketmanager.entities.user.UserImplementation

class Change {
    var userImplementation: UserImplementation
        private set
    var fieldChanged: String
        private set
    var oldValue: String
        private set
    var newValue: String
        private set

    constructor(userImplementation: UserImplementation, fieldChanged: String, oldValue: String, newValue: String) {
        this.userImplementation = userImplementation
        this.fieldChanged = fieldChanged
        this.oldValue = oldValue
        this.newValue = newValue
    }

    override fun toString(): String {
        return "O usuário ${userImplementation.username} alterou o campo ${fieldChanged} de ${oldValue} para ${newValue}."
    }
}
