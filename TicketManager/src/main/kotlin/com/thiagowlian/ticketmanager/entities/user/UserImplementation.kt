package com.thiagowlian.ticketmanager.entities.user

class UserImplementation(username: String, userType: UserType) : User {
    override var username: String = username
    override var userType: UserType = userType
}
