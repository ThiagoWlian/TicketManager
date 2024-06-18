package com.thiagowlian.ticketmanager.interfaceAdapter.mapper.user

import jakarta.persistence.*

@Entity
@Table(name = "user")
data class UserDataMapper(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @Column(name = "username")
        var username: String,
        @Column(name = "type")
        var userType: String
)
