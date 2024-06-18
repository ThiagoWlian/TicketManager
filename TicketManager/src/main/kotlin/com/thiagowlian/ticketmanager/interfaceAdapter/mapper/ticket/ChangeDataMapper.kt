package com.thiagowlian.ticketmanager.interfaceAdapter.mapper.ticket

import com.thiagowlian.ticketmanager.interfaceAdapter.mapper.user.UserDataMapper
import jakarta.persistence.*

@Entity
@Table(name = "ticket_change")
data class ChangeDataMapper(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "author")
        val author: UserDataMapper,
        @Column(name = "field")
        val fieldChanged: String,
        @Column(name = "old_value")
        val oldValue: String,
        @Column(name = "new_valeu")
        val newValue: String
)
